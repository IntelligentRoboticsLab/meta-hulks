SRC_URI += "\
    git://git@github.com/HULKs/nao.git;protocol=ssh;branch=master; \
    file://aliveness.service \
  "
SRCREV = "a48c7630e80ec2f7d51796a9e924060eca20472f"

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
