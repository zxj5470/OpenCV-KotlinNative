import libopencv2_highgui.*
import libopencv2_imgproc.*

fun main(args: Array<String>) {
    val img = cvLoadImageM("../lena.jpg", 0) ?: return
    val result = cvCloneMat(img)
    cvThreshold(img, result, 70.0, 160.0, CV_THRESH_BINARY)
    cvSaveImage("../pic/lena_binary.jpg", result, null)
    cvShowImage("lena_binary", result)
    cvWaitKey(0)
}