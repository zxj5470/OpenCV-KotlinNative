cmake_minimum_required(VERSION 3.8)

set(CMAKE_MODULE_PATH ${CMAKE_CURRENT_LIST_DIR}/KotlinCMakeModule)

project(OpenCV-KotlinNative Kotlin)

# OpenCV2
set(OCV2_LIBRARY "-lopencv_core -lopencv_highgui -lopencv_imgproc")
if (APPLE)
    set(OPENCV2_INCLUDE_DIR /usr/local/opt/opencv@2/include)
elseif (UNIX)
    set(OPENCV2_INCLUDE_DIR /usr/local/include)
endif ()

message("${OPENCV2_INCLUDE_DIR}")

##### opencv2
cinterop(
        NAME libopencv2_core
        DEF_FILE src/c_interop/libopencv2_core.def
        COMPILER_OPTS "-I ${OPENCV2_INCLUDE_DIR}"
)

cinterop(
        NAME libopencv2_highgui
        DEF_FILE src/c_interop/libopencv2_highgui.def
        COMPILER_OPTS "-I ${OPENCV2_INCLUDE_DIR}"
)

cinterop(
        NAME libopencv2_imgproc
        DEF_FILE src/c_interop/libopencv2_imgproc.def
        COMPILER_OPTS "-I ${OPENCV2_INCLUDE_DIR}"
)


##### execs
konanc_executable(
        NAME OpenCV_Hello_Lena_K
        SOURCES samples/hello_lena/personal_version src/kotlin/
        LIBRARIES libopencv2_highgui
        LINKER_OPTS "${OCV2_LIBRARY}"
)

konanc_executable(
        NAME OpenCV_Hello_Lena_C
        SOURCES samples/hello_lena/c_interop_version
        LIBRARIES libopencv2_highgui
        LINKER_OPTS "${OCV2_LIBRARY}"
)

konanc_executable(
        NAME OpenCV_Image_Scale
        SOURCES samples/image_scale/c_interop_version src/kotlin/
        LIBRARIES libopencv2_highgui
        LINKER_OPTS "${OCV2_LIBRARY}"
)

#####



konanc_executable(
        NAME OpenCV2_Simple_Run
        SOURCES samples/cv2_simple_run/
        LIBRARIES libopencv2_core
        LINKER_OPTS "${OCV2_LIBRARY}"
)

konanc_executable(
        NAME OpenCV_Simple_Highgui
        SOURCES samples/cv2_simple_highgui/
        LIBRARIES libopencv2_highgui
        LINKER_OPTS "${OCV2_LIBRARY}"
)

konanc_executable(
        NAME OpenCV_Simple_Output
        SOURCES samples/SaveImage/
        LIBRARIES libopencv2_highgui libopencv2_imgproc
        LINKER_OPTS "${OCV2_LIBRARY}"
)