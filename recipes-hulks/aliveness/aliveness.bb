SUMMARY = "aliveness"
HOMEPAGE = "https://hulks.de"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING;md5=5b4473596678d62d9d83096273422c8c"

inherit cargo

SRC_URI = "git://github.com/HULKs/hulk.git;branch=main;protocol=https"
SRCREV = "233c15cdb4f58be01f5b31f789b0ca3bbe613c89"
S = "${WORKDIR}/git/tools/aliveness"

SYSTEMD_SERVICE:${PN} = "aliveness.service enp4s0-wait-online.service"
SRC_URI += "file://aliveness.service"
SRC_URI += "file://enp4s0-wait-online.service"

inherit systemd

do_install:append () {
  install -d "${D}${systemd_unitdir}/system"
  install -m 0644 "${WORKDIR}/aliveness.service" "${D}${systemd_unitdir}/system/"
  install -m 0644 "${WORKDIR}/enp4s0-wait-online.service" "${D}${systemd_unitdir}/system/"
}

require aliveness-crates.inc
