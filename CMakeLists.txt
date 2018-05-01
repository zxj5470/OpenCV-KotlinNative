cmake_minimum_required(VERSION 3.8)

set(CMAKE_MODULE_PATH ${CMAKE_CURRENT_LIST_DIR}/KotlinCMakeModule)

project(OpenCV-KotlinNative Kotlin)

# Linux
# legacy
#set(OCV1_INCLUDE_DIR /usr/local/include)
#set(OCV1_LIBRARY "-lcv -lcxcore -lcvaux -lhighgui -lml")

# OpenCV2
set(OCV2_LIBRARY "-lopencv_core -lopencv_highgui")
if (APPLE)
    # /usr/local/Cellar/opencv@2/2.4.13.6/include
    set(OPENCV2_INCLUDE_DIR /usr/local/Cellar/opencv@2/2.4.13.6/include)
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