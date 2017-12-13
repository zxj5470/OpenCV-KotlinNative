package kotlin.opencv.zxj5470.model

import kotlinx.cinterop.CPointer
import libhighgui.*

class Image(fileName: String, isColor: Int = CV_LOAD_IMAGE_COLOR) {
    var self: CPointer<IplImage>? = null

    //cvShowImage...showImage
    fun show(title: String = "image", flags: Int = CV_WINDOW_AUTOSIZE,then:()->Unit={}) {
        cvNamedWindow(title, flags)
        cvShowImage(title, self)
        then()
    }

    init {
        self = cvLoadImage(fileName, isColor)
    }

}