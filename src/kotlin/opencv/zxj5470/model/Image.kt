package kotlin.opencv.zxj5470.model

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import libhighgui.*

class Image(
        private var fileName: String,
        isColor: Int = CV_LOAD_IMAGE_COLOR) {
    var self: CPointer<IplImage>? = null
    val width: Int
        get() = self!!.pointed.width
    val height: Int
        get() = self!!.pointed.height


    //cvShowImage...showImage
    fun show(title: String = fileName, flags: Int = CV_WINDOW_AUTOSIZE, then: () -> Unit = {}) {
        cvNamedWindow(title, flags)
        cvShowImage(title, self)
        then()
    }

    init {
        self = cvLoadImage(fileName, isColor)
    }

    fun clone() {
        val new = cvClone(self)
    }

    operator fun get(i: Int, j: Int) {

    }
}