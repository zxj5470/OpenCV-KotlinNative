# OpenCV-KotlinNative

<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=true} -->
<!-- code_chunk_output -->

* [OpenCV-KotlinNative](#opencv-kotlinnative)
	* [Dependencies](#dependencies)
		* [Build dependencies](#build-dependencies)
		* [Runtime dependencies](#runtime-dependencies)
	* [Environment](#environment)
	* [Run](#run)
		* [sample1: Hello Lena](#sample1-hello-lena)
		* [sample2: Scale a image](#sample2)
	* [C_Interop](#c_interop)
	* [Misc (Linux)](#misc-linux)

<!-- /code_chunk_output -->

## Dependencies

### Build dependencies 
- OS: 
    - Linux (haven't been tested for opencv 2.4)
    - macOS Sierra 10.12
- konanc
- OpenCV 2.4.13

### Runtime dependencies
- libopencv_core
- libopencv_highgui

## Environment
- <del>Linux 4.9.0-deepin13-amd64 (Deepin 15.5) (PC)</del>
- macOS Sierra 10.12
- CLion (With Kotlin and Kotlin/Native Plugins)
- JDK 1.8
- Kotlin Native: kotlin-native-linux-0.6.2

## Run
### sample1: Hello Lena
[hello_lena-c_interop_version](https://github.com/zxj5470/OpenCV-KotlinNative/blob/master/samples/hello_lena/c_interop_version/CInterop.kt)
![finally you can see lena.jpg](./pic/pic0.png)

### sample2: Scale a image
Scale 
- It needs about 30 seconds ... please wait a moment 
- (and about 15 seconds in OS X with Intel i5 2.3 GHz)
- so if you have a better algorithm to enhance the effect please tell me....)
![scale](./pic/pic1.png)

## C_Interop
What you can interact-operator:

- [X] libcv
- [X] libhighgui
- [X] libcxcore

```kotlin
import libcv.*
```

Cannot make klib on account of cpp

- :x: libcvaux 
- :x: libml 


## Misc (Linux)

if your libs were installed in `/usr/local/lib` (Makefile default)
then do these as follows:

```bash
$ cat /etc/ld.so.conf
```

appand `/usr/local/lib` at the end:

```
include /etc/ld.so.conf.d/*.conf   # default
/usr/local/lib
```

command

```bash
sudo ldconfig
```
