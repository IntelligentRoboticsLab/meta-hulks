inherit cargo

SRC_URI += " \
    git://git@github.com/hulks/hulk.git;protocol=https;branch=main; \
    file://hula.service \
"
SRCREV = "3a7de7ad6b0291a2efa5ec2a8be46ecdf5d89492"
S = "${WORKDIR}/git/tools/hula"

HOMEPAGE = "github.com/HULKs/hulk"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING;md5=5b4473596678d62d9d83096273422c8c"

SRC_URI += " \
    crate://crates.io/ahash/0.7.6 \
    crate://crates.io/aho-corasick/0.7.20 \
    crate://crates.io/android_system_properties/0.1.5 \
    crate://crates.io/anyhow/1.0.66 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/build-env/0.3.1 \
    crate://crates.io/bumpalo/3.11.1 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/cc/1.0.77 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/chrono/0.4.23 \
    crate://crates.io/clap/4.0.29 \
    crate://crates.io/clap_lex/0.3.0 \
    crate://crates.io/codespan-reporting/0.11.1 \
    crate://crates.io/core-foundation-sys/0.8.3 \
    crate://crates.io/cstr-argument/0.1.2 \
    crate://crates.io/ctrlc/3.2.3 \
    crate://crates.io/cxx-build/1.0.82 \
    crate://crates.io/cxx/1.0.82 \
    crate://crates.io/cxxbridge-flags/1.0.82 \
    crate://crates.io/cxxbridge-macro/1.0.82 \
    crate://crates.io/dbus/0.9.6 \
    crate://crates.io/dlv-list/0.3.0 \
    crate://crates.io/epoll/4.3.1 \
    crate://crates.io/errno-dragonfly/0.1.2 \
    crate://crates.io/errno/0.2.8 \
    crate://crates.io/fern/0.6.1 \
    crate://crates.io/foreign-types-macros/0.2.2 \
    crate://crates.io/foreign-types-shared/0.3.1 \
    crate://crates.io/foreign-types/0.5.0 \
    crate://crates.io/getrandom/0.2.8 \
    crate://crates.io/glob/0.3.0 \
    crate://crates.io/hashbrown/0.12.3 \
    crate://crates.io/hermit-abi/0.2.6 \
    crate://crates.io/hostname/0.3.1 \
    crate://crates.io/iana-time-zone-haiku/0.1.1 \
    crate://crates.io/iana-time-zone/0.1.53 \
    crate://crates.io/io-lifetimes/1.0.3 \
    crate://crates.io/ipnetwork/0.19.0 \
    crate://crates.io/is-terminal/0.4.1 \
    crate://crates.io/itoa/1.0.4 \
    crate://crates.io/js-sys/0.3.60 \
    crate://crates.io/libc/0.2.137 \
    crate://crates.io/libdbus-sys/0.2.2 \
    crate://crates.io/libsystemd-sys/0.9.3 \
    crate://crates.io/link-cplusplus/1.0.7 \
    crate://crates.io/linux-raw-sys/0.1.3 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/match_cfg/0.1.0 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memoffset/0.7.1 \
    crate://crates.io/nix/0.25.0 \
    crate://crates.io/nix/0.26.1 \
    crate://crates.io/no-std-net/0.6.0 \
    crate://crates.io/num-integer/0.1.45 \
    crate://crates.io/num-traits/0.2.15 \
    crate://crates.io/once_cell/1.16.0 \
    crate://crates.io/ordered-multimap/0.4.3 \
    crate://crates.io/os_str_bytes/6.4.1 \
    crate://crates.io/paste/1.0.9 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/pkg-config/0.3.26 \
    crate://crates.io/pnet/0.31.0 \
    crate://crates.io/pnet_base/0.31.0 \
    crate://crates.io/pnet_datalink/0.31.0 \
    crate://crates.io/pnet_macros/0.31.0 \
    crate://crates.io/pnet_macros_support/0.31.0 \
    crate://crates.io/pnet_packet/0.31.0 \
    crate://crates.io/pnet_sys/0.31.0 \
    crate://crates.io/pnet_transport/0.31.0 \
    crate://crates.io/proc-macro2/1.0.47 \
    crate://crates.io/quote/1.0.21 \
    crate://crates.io/regex-syntax/0.6.28 \
    crate://crates.io/regex/1.7.0 \
    crate://crates.io/rmp-serde/1.1.1 \
    crate://crates.io/rmp/0.8.11 \
    crate://crates.io/rust-ini/0.18.0 \
    crate://crates.io/rustix/0.36.4 \
    crate://crates.io/ryu/1.0.11 \
    crate://crates.io/scratch/1.0.2 \
    crate://crates.io/serde/1.0.148 \
    crate://crates.io/serde_derive/1.0.148 \
    crate://crates.io/serde_json/1.0.89 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/strsim/0.10.0 \
    crate://crates.io/syn/1.0.105 \
    crate://crates.io/systemd/0.10.0 \
    crate://crates.io/termcolor/1.1.3 \
    crate://crates.io/time/0.1.45 \
    crate://crates.io/unicode-ident/1.0.5 \
    crate://crates.io/unicode-width/0.1.10 \
    crate://crates.io/utf8-cstr/0.1.6 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/wasi/0.10.0+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.83 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.83 \
    crate://crates.io/wasm-bindgen-macro/0.2.83 \
    crate://crates.io/wasm-bindgen-shared/0.2.83 \
    crate://crates.io/wasm-bindgen/0.2.83 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-sys/0.42.0 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.0 \
    crate://crates.io/windows_aarch64_msvc/0.42.0 \
    crate://crates.io/windows_i686_gnu/0.42.0 \
    crate://crates.io/windows_i686_msvc/0.42.0 \
    crate://crates.io/windows_x86_64_gnu/0.42.0 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.0 \
    crate://crates.io/windows_x86_64_msvc/0.42.0 \
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
