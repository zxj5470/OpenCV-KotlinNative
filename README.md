# OpenCV-KotlinNative

<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->
<!-- code_chunk_output -->

* [OpenCV-KotlinNative](#opencv-kotlinnative)
	* [Dependencies](#dependencies)
		* [Build dependencies](#build-dependencies)
		* [Runtime dependencies](#runtime-dependencies)
	* [Environment](#environment)
	* [Run](#run)
		* [sample1: Hello Lena](#sample1-hello-lena)
		* [sample2:](#sample2)
	* [C_Interop](#c_interop)
	* [Misc](#misc)

<!-- /code_chunk_output -->

## Dependencies

### Build dependencies 
- OS: Linux 
- konanc dependencies
    - Java (because KNC still cannot bootstrap...)
    - clang-llvm-3.9.0-linux-x86-64
    - libffi-3.2.1-2-linux-x86-64
    - target-gcc-toolchain-3-linux-x86-64
- OpenCV 1.0
    - (And you need update many files……)
    - (Maybe I will create a repository for OpenCV 1.0 Version )

### Runtime dependencies
- libcv.so.1
- libcvaux.so.1
- libcxcore.so.1
- libhighgui.so.1
- libml.so.1

## Environment
- Linux 4.9.0-deepin13-amd64 (Deepin 15.5) (PC)
- CLion (With Kotlin and Kotlin/Native Plugins)
- JDK 1.8.0_152
- Kotlin 1.1.4 (CLion Kotlin Plugin Default)
- Kotlin Native: kotlin-native-linux-0.4-dev-102

## Mac OS X Build:
- opencv 2.14.3

## Run
### sample1: Hello Lena
[hello_lena-c_interop_version](https://github.com/zxj5470/OpenCV-KotlinNative/blob/master/samples/hello_lena/c_interop_version/CInterop.kt)
![finally you can see lena.jpg](./pic/pic0.png)

### sample2:
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
