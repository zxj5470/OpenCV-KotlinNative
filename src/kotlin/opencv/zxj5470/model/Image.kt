package kotlin.opencv.zxj5470.model

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import libopencv2_highgui.*

class Image(
        private var fileName: String,
        isColor: Int = CV_LOAD_IMAGE_COLOR) {
    var self: CPointer<IplImage>? = cvLoadImage(fileName, isColor)
    val width: Int
        get() = self?.pointed?.width ?: -1
    val height: Int
        get() = self?.pointed?.height ?: -1

    /**
     *
     * @param title String
     * @param flags Int
     * @param then Function0<Unit>
     * @return Unit
     */
    //cvShowImage...showImage
    fun show(title: String = fileName, flags: Int = CV_WINDOW_AUTOSIZE, then: () -> Unit = {}) {
        cvNamedWindow(title, flags)
        cvShowImage(title, self)
        then()
    }
}