SUMMARY = "Add sound files to the image"
LICENSE = "CLOSED"

SRC_URI = " \
            file://weeeee.wav \
          "

do_install() {
    install -d ${D}${sysconfdir}/sounds/
    install -m 0644 ${WORKDIR}/weeeee.wav ${D}${sysconfdir}/sounds/
}

FILES:${PN} = " \
                ${sysconfdir}/sounds/weeeee.wav \
              "
