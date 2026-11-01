#!/bin/sh
rm -rf /home/jitpack/tools/jdk16/
mkdir /home/jitpack/tools/jdk16/
wget -nv https://github.com/adoptium/temurin16-binaries/releases/download/jdk-16.0.2%2B7/OpenJDK16U-jdk_x64_linux_hotspot_16.0.2_7.tar.gz -O /home/jitpack/tools/jdk16/jdk16.tar.gz
tar xfz /home/jitpack/tools/jdk16/jdk16.tar.gz --strip-components=1 -C /home/jitpack/tools/jdk16

rm -rf /home/jitpack/tools/jdk8/
mkdir /home/jitpack/tools/jdk8/
wget -nv https://github.com/adoptium/temurin8-binaries/releases/download/jdk8u504-b01/OpenJDK8U-jdk_x64_linux_hotspot_8u504b01.tar.gz -O /home/jitpack/tools/jdk8/jdk8.tar.gz
tar xfz /home/jitpack/tools/jdk8/jdk16.tar.gz --strip-components=1 -C /home/jitpack/tools/jdk8
