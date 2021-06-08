SUMMARY = "HULKs CMake Test"
HOMEPAGE = "https://hulks.de"
LICENSE = "CLOSED"

SRC_URI = " \
            file://CMakeLists.txt \
            file://main.cpp \
          "

DEPENDS = " \
           boost \
           bzip2 \
           libjpeg-turbo \
           libpng \
           zlib \
           alsa-lib \
           portaudio-v19 \
           fftw \
           libsndfile1 \
           msgpack-c \
           libogg \
           libopus \
           opusfile \
           compilednn \
           libeigen \
          "

S = "${WORKDIR}"

inherit cmake

RDEPENDS_${PN} += "bash"
