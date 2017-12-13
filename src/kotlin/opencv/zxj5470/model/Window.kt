package kotlin.opencv.zxj5470.model

import libhighgui.cvDestroyAllWindows
import libhighgui.cvDestroyWindow
import libhighgui.cvWaitKey

object Window {
    fun waitKey(delay: Int = 0) = cvWaitKey(0)
    fun destroyWindow(name:String)= cvDestroyWindow(name)
    fun destroyAllWindows()= cvDestroyAllWindows()
}