package kotlin.opencv.zxj5470.model

import libopencv2_highgui.*

open class BasePixel(type: Int = CV_8U)

data class GreyPixel(val type: Int) : BasePixel(type = CV_8U)