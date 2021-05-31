SUMMARY = "A portable audio library"
SECTION = "libs/multimedia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=26107732c2ab637c5710446fcfaf02df"

PV = "v190700"

SRC_URI = "git://github.com/PortAudio/portaudio.git \
           file://0001-Find-jack.patch \
           file://0001-Add-portaudio-namespace.patch \
           "
SRCREV = "147dd722548358763a8b649b3e4b41dfffbcfbb6"
S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DPA_BUILD_STATIC=OFF"

PACKAGECONFIG ??= "alsa jack"
PACKAGECONFIG[alsa] = ",,alsa-lib"
PACKAGECONFIG[jack] = ",,jack"
PACKAGECONFIG[examples] = "-DPA_BUILD_EXAMPLES=ON,-DPA_BUILD_EXAMPLES=OFF"

do_install_append() {
    if [ -d ${B}/examples ]; then
        install -d ${D}${bindir}
        for example in ${B}/examples/pa*; do
            install -m755 $example ${D}${bindir}/
        done
    fi
}

FILES_SOLIBSDEV = ""
#FILES_${PN} += "${libdir}/libportaudio.so"
#FILES_${PN} += "${libdir}/cmake/portaudio/*"
#FILES_${PN} += "${libdir}/pkgconfig/*"
#FILES_${PN} += "*"
#FILES_${PN} += "${libdir}/*"
FILES_${PN} += "/usr/lib/libportaudio.so"
FILES_${PN} += "/usr/lib/cmake/portaudio/*"
FILES_${PN} += "/usr/lib/pkgconfig/*"
#FILES_${PN} += "${libdir}/libportaudio.so"
