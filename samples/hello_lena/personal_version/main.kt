import kotlin.opencv.zxj5470.ext.*
import kotlin.opencv.zxj5470.model.*

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("please input a parameter for loadImage.....")
        return
    }

    val img= Image(args[0])
    val titleName="title"

    img.show(titleName){
        Window.waitKey()
        titleName.windowDestroy()
    }
}