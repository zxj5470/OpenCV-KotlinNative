import libhighgui.*

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("please input a parameter for loadImage.....")
        return
    }

    val image = cvLoadImage(args[0], CV_LOAD_IMAGE_COLOR)
    cvNamedWindow("title", CV_WINDOW_AUTOSIZE)
    cvShowImage("title", image)
    cvWaitKey(0)
    cvDestroyAllWindows()
}