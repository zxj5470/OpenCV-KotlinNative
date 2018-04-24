/**
 * @author zxj5470
 * @date 2018/4/24
 */
import libopencv2_highgui.*

fun main(args: Array<String>) {
    if(args.isEmpty()){
        println("please input a param for loadImage......")
        return
    }
    val image= cvLoadImage(args[0], CV_LOAD_IMAGE_COLOR)
    cvNamedWindow("title", CV_WINDOW_AUTOSIZE)
    cvShowImage("title",image)
    cvWaitKey(0)
    cvDestroyAllWindows()
}
