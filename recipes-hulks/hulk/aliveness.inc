SRC_URI += "\
    git://git@github.com/HULKs/nao.git;protocol=ssh;branch=master; \
    file://aliveness.service \
  "
SRCREV = "c3683fac92f539e03b7f35b2d741c31f6f46b3b4"

S = "${WORKDIR}/git/tools/aliveness"

DEPENDS += "dbus"
RDEPENDS_${PN} += "dbus"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "aliveness.service"

do_install_append() {
  install -d ${D}${systemd_unitdir}/system/
  install -m 0644 ${WORKDIR}/aliveness.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += "${systemd_unitdir}/system/aliveness.service"

inherit systemd
