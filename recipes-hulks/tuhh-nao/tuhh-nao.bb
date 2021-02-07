SUMMARY = "Nao SPL Robocup -- HULKs setup"
HOMEPAGE = "https://hulks.de"
LICENSE = "CLOSED"

SRC_URI = " \
            file://camera-reset \
            file://hulk.service \
          "

do_install() {
  install -d ${D}${bindir}
  install -m 755 ${WORKDIR}/camera-reset ${D}${bindir}

  install -d ${D}${systemd_unitdir}/system/
  install -m 0644 ${WORKDIR}/hulk.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} = "\
                ${systemd_unitdir}/system/hulk.service \
                ${bindir}/camera-reset \
              "

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "hulk.service"

inherit systemd
