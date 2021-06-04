SUMMARY = "HULKs CMake Test"
HOMEPAGE = "https://hulks.de"
LICENSE = "CLOSED"

SRC_URI = " \
            file://vcpkg-ports \
            file://CMakeLists.txt \
            file://main.cpp \
            file://vcpkg.json \
            file://vcpkg.sh \
            file://yocto.sh \
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

srcdir = "${prefix}/src/${PN}"

# disable QA check:
# QA Issue: /usr/src/hulks-cmake/yocto.sh contained in package hulks-cmake requires /bin/bash, but no providers found in RDEPENDS_hulks-cmake? [file-rdeps]
INSANE_SKIP_${PN} = "file-rdeps"

do_install_append() {
  install -d "${D}${srcdir}"
  cp --preserve=mode,timestamps --recursive "${WORKDIR}/vcpkg-ports" "${D}${srcdir}"
  install -m 644 "${WORKDIR}/CMakeLists.txt" "${D}${srcdir}"
  install -m 644 "${WORKDIR}/main.cpp" "${D}${srcdir}"
  install -m 644 "${WORKDIR}/vcpkg.json" "${D}${srcdir}"
  install -m 755 "${WORKDIR}/vcpkg.sh" "${D}${srcdir}"
  install -m 755 "${WORKDIR}/yocto.sh" "${D}${srcdir}"
}

FILES_${PN} += "\
                ${srcdir}/vcpkg-ports \
                ${srcdir}/CMakeLists.txt \
                ${srcdir}/main.cpp \
                ${srcdir}/vcpkg.json \
                ${srcdir}/vcpkg.sh \
                ${srcdir}/yocto.sh \
               "
