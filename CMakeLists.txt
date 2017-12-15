cmake_minimum_required(VERSION 3.8)

set(CMAKE_MODULE_PATH ${CMAKE_CURRENT_LIST_DIR}/KotlinCMakeModule)
set(CMAKE_C_COMPILER gcc)
set(CMAKE_CXX_COMPILER g++)

project(OpenCV-KotlinNative Kotlin)
set(OCV1_INCLUDE_DIR /usr/local/include)
set(CMAKE_FIND_ROOT_PATH_MODE_INCLUDE /usr/local/include)
set(OCV1_LIBRARY "-lcv -lcxcore -lcvaux -lhighgui -lml")

link_directories(/usr/local/lib)

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
        NAME OpenCV_Iamge_Scale
        SOURCES samples/image_scale/c_interop_version src/kotlin/
        LIBRARIES cv_kt highgui_kt cxcore_kt
        LINKER_OPTS "${OCV1_LIBRARY}"
)