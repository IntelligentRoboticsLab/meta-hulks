SRC_URI += " \
    file://hula.service \
"

inherit pkgconfig

DEPENDS += " \
            dbus \
            systemd \
           "
RDEPENDS:${PN} += " \
                   dbus \
                   systemd \
                  "

inherit systemd
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "hula.service"

do_install:append() {
  install -d ${D}${systemd_unitdir}/system/
  install -m 0644 ${WORKDIR}/hula.service ${D}${systemd_unitdir}/system/
}

FILES:${PN} += "${systemd_unitdir}/system/hula.service"
