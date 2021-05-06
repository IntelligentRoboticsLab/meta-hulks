SUMMARY = "Nao SPL Robocup -- HULKs setup"
HOMEPAGE = "https://hulks.de"
LICENSE = "CLOSED"

SRC_URI = " \
            file://camera-reset \
            file://hulk.service \
            file://launchTuhhNao \
            file://hulk \
          "

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "hulk.service"

inherit systemd

do_install() {
  install -d ${D}${bindir}
  install -m 755 ${WORKDIR}/camera-reset ${D}${bindir}
  install -m 755 ${WORKDIR}/launchTuhhNao ${D}${bindir}
  install -m 755 ${WORKDIR}/hulk ${D}${bindir}

  install -d ${D}${systemd_unitdir}/system/
  install -m 0644 ${WORKDIR}/hulk.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} = "\
                ${bindir}/camera-reset \
                ${bindir}/launchTuhhNao \
                ${bindir}/hulk \
                ${systemd_unitdir}/system/hulk.service \
              "

