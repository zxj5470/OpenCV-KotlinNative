import kotlinx.cinterop.*
import libopencv2_highgui.*
import kotlin.opencv.zxj5470.model.*

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("please input a parameter for loadImage.....")
        return
    }

    val img = Image(args[0], CV_LOAD_IMAGE_GRAYSCALE)

    val titleName = "title"
    val outTitle = "title2"
    //the window is bound by titleName
    img.show(titleName)
    val scale = 1.3

    val width = (256 * scale).toInt()
    val height = (256 * scale).toInt()

    //create a gray Image
    val outImage = cvCreateImage(cvSize(width, height), IPL_DEPTH_8U, 1)
    val outPtr = outImage!!.pointed
    val outWidth = outPtr.width
    val outHeight = outPtr.height
    for (i in 0 until outWidth) {
        for (j in 0 until outHeight) {
            val h = i / scale   //原图对应坐标
            val w = j / scale
            val ret = reSampleCubic(h, w, img.self!!.pointed).toScalar()
            cvSet2D(outImage, j, i, ret)
        }
    }
    cvNamedWindow(outTitle, CV_WINDOW_AUTOSIZE)
    cvShowImage(outTitle, outImage)

    Window.waitKey()
    Window.destroyAllWindows()
}

val values = Array(4, { Array(4) { 0.0 } })

fun reSampleCubic(w: Double, h: Double, source: IplImage): Double {

    val i: Int = h.toInt()
    val j: Int = w.toInt()
    if ((i - 2) < 0 || (j - 2) < 0 || (j + 3) > source.height || (i + 3) > source.width)
        return 0.0
    var ret = 0.0

    (j - 1..j + 2).forEachIndexed { s, r ->
        (i - 1..i + 2).forEachIndexed { t, c ->
            cvGet2D(source.ptr, c, r).useContents { values[s][t] = `val`[0] }
        }
    }
    val u = h - i   //取小数部分
    val v = w - j
    val A = Array(4, { 0.0 })
    val C = Array(4, { 0.0 })
    (1 downTo -2).forEachIndexed { s, distance ->
        A[s] = S(u + distance)
        C[s] = S(v + distance)
    }
    (0 until 4).forEach { s ->
        (0 until 4).forEach { t ->
            ret += values[s][t] * A[t] * C[s]
        }
    }
    return ret
}

fun S(v: Double, a: Double = -0.5): Double {
    val x = if (v < 0) -v else v
    return when {
        x < 1.0 -> (a + 2) * x * x * x - (a + 3) * x * x + 1
        x < 2 -> a * x * x * x - 5 * a * x * x + 8 * a * x - 4 * a
        else -> 0.0
    }
}

inline fun toScalar(d: Double): CValue<CvScalar> = cvScalar(d, d, d, d)
inline fun Double.toScalar() = toScalar(this)