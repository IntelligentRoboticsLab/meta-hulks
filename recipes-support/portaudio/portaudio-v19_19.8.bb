SUMMARY = "A portable audio library"
SECTION = "libs/multimedia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=26107732c2ab637c5710446fcfaf02df"

SRC_URI = "git://github.com/PortAudio/portaudio.git \
           file://0001-Merge-cmake_rewrite-of-github.com-Be-ing-portaudio.g.patch \
           file://0001-Add-portaudio-namespace.patch \
           "
SRCREV = "9413fa051f0f9b830c117cb3dc4f6d675e330a99"
S = "${WORKDIR}/git"

inherit cmake
