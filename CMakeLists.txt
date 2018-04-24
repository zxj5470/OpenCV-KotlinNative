cmake_minimum_required(VERSION 3.8)

set(CMAKE_MODULE_PATH ${CMAKE_CURRENT_LIST_DIR}/KotlinCMakeModule)

project(OpenCV-KotlinNative Kotlin)

# Linux
set(OCV1_INCLUDE_DIR /usr/local/include)
set(OCV1_LIBRARY "-lcv -lcxcore -lcvaux -lhighgui -lml")

# OpenCV2
set(OCV2_LIBRARY "-lopencv_core -lopencv_highgui")
find_package(OpenCV REQUIRED)
message("${OpenCV_INCLUDE_DIRS}")
# /usr/local/Cellar/opencv@2/2.4.13.6/include
message("${OpenCV_LIBS}")
# opencv_videostab;opencv_video;opencv_ts;opencv_superres;opencv_stitching;opencv_photo;opencv_ocl;opencv_objdetect;opencv_nonfree;opencv_ml;opencv_legacy;opencv_imgproc;opencv_highgui;opencv_gpu;opencv_flann;opencv_features2d;opencv_core;opencv_contrib;opencv_calib3d
set(OPENCV2_INCLUDE_DIR /usr/local/Cellar/opencv@2/2.4.13.6/include)
include_directories(${OpenCV_INCLUDE_DIRS})

##### Linux CV1
##### LEGACY
link_directories(/usr/local/lib)
# cv1
cinterop(
        NAME cv_kt
        DEF_FILE src/c_interop/libcv.def
        COMPILER_OPTS "-I ${OCV1_INCLUDE_DIR}"
)

cinterop(
        NAME highgui_kt
        DEF_FILE src/c_interop/libhighgui.def
        COMPILER_OPTS "-I ${OCV1_INCLUDE_DIR}"
)

cinterop(
        NAME cxcore_kt
        DEF_FILE src/c_interop/libcxcore.def
        COMPILER_OPTS "-I ${OCV1_INCLUDE_DIR}"
)

konanc_executable(
        NAME OpenCV_Hello_Lena_K
        SOURCES samples/hello_lena/personal_version src/kotlin/
        LIBRARIES cv_kt highgui_kt cxcore_kt
        LINKER_OPTS "${OCV1_LIBRARY}"
)

konanc_executable(
        NAME OpenCV_Hello_Lena_C
        SOURCES samples/hello_lena/c_interop_version
        LIBRARIES cv_kt highgui_kt cxcore_kt
        LINKER_OPTS "${OCV1_LIBRARY}"
)

konanc_executable(
        NAME OpenCV_Image_Scale
        SOURCES samples/image_scale/c_interop_version src/kotlin/
        LIBRARIES cv_kt highgui_kt cxcore_kt
        LINKER_OPTS "${OCV1_LIBRARY}"
)

#####

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

konanc_executable(
        NAME OpenCV2_Simple_Run
        SOURCES samples/simple_run/
        LIBRARIES libopencv2_core
        LINKER_OPTS "${OCV2_LIBRARY}"
)

konanc_executable(
        NAME OpenCV_Simple_Highgui
        SOURCES samples/simple_run_cv2_highgui/
        LIBRARIES libopencv2_highgui
        LINKER_OPTS "${OCV2_LIBRARY}"
)