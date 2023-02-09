SUMMARY = "aliveness"
HOMEPAGE = "https://hulks.de"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING;md5=5b4473596678d62d9d83096273422c8c"

inherit cargo

SRC_URI = "git://github.com/hulks/hulk;branch=main;protocol=https"
SRCREV = "cce0d1af62f8126f6e51e648607d30d0c30a3657"
S = "${WORKDIR}/git/tools/aliveness"

inherit systemd

SYSTEMD_SERVICE:${PN} = "aliveness.service"

do_install:append () {
  install -d "${D}${systemd_unitdir}/system"
  install -m 0644 "${WORKDIR}/aliveness.service" "${D}${systemd_unitdir}/system/"
}

SRC_URI += " \
    file://aliveness.service \
    crate://crates.io/addr2line/0.17.0 \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/aho-corasick/0.7.20 \
    crate://crates.io/async-broadcast/0.5.0 \
    crate://crates.io/async-channel/1.8.0 \
    crate://crates.io/async-executor/1.5.0 \
    crate://crates.io/async-global-executor/2.3.1 \
    crate://crates.io/async-io/1.12.0 \
    crate://crates.io/async-lock/2.6.0 \
    crate://crates.io/async-recursion/1.0.2 \
    crate://crates.io/async-std/1.12.0 \
    crate://crates.io/async-task/4.3.0 \
    crate://crates.io/async-trait/0.1.61 \
    crate://crates.io/atomic-waker/1.0.0 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/backtrace/0.3.66 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/block-buffer/0.10.3 \
    crate://crates.io/blocking/1.3.0 \
    crate://crates.io/bumpalo/3.11.1 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/bytes/1.3.0 \
    crate://crates.io/cc/1.0.77 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/color-eyre/0.6.2 \
    crate://crates.io/color-spantrace/0.2.0 \
    crate://crates.io/concurrent-queue/2.0.0 \
    crate://crates.io/configparser/3.0.2 \
    crate://crates.io/cpufeatures/0.2.5 \
    crate://crates.io/crossbeam-utils/0.8.14 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/ctor/0.1.26 \
    crate://crates.io/derivative/2.2.0 \
    crate://crates.io/digest/0.10.6 \
    crate://crates.io/dirs-sys/0.3.7 \
    crate://crates.io/dirs/4.0.0 \
    crate://crates.io/enumflags2/0.7.5 \
    crate://crates.io/enumflags2_derive/0.7.4 \
    crate://crates.io/env_logger/0.10.0 \
    crate://crates.io/errno-dragonfly/0.1.2 \
    crate://crates.io/errno/0.2.8 \
    crate://crates.io/event-listener/2.5.3 \
    crate://crates.io/eyre/0.6.8 \
    crate://crates.io/fastrand/1.8.0 \
    crate://crates.io/futures-channel/0.3.25 \
    crate://crates.io/futures-core/0.3.25 \
    crate://crates.io/futures-io/0.3.25 \
    crate://crates.io/futures-lite/1.12.0 \
    crate://crates.io/futures-macro/0.3.25 \
    crate://crates.io/futures-sink/0.3.25 \
    crate://crates.io/futures-task/0.3.25 \
    crate://crates.io/futures-util/0.3.25 \
    crate://crates.io/generic-array/0.14.6 \
    crate://crates.io/getrandom/0.2.8 \
    crate://crates.io/gimli/0.26.2 \
    crate://crates.io/gloo-timers/0.2.5 \
    crate://crates.io/hermit-abi/0.1.19 \
    crate://crates.io/hermit-abi/0.2.6 \
    crate://crates.io/hex/0.4.3 \
    crate://crates.io/hostname/0.3.1 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/indenter/0.3.3 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/io-lifetimes/1.0.4 \
    crate://crates.io/is-terminal/0.4.2 \
    crate://crates.io/itoa/1.0.4 \
    crate://crates.io/js-sys/0.3.60 \
    crate://crates.io/kv-log-macro/1.0.7 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/libc/0.2.138 \
    crate://crates.io/linux-raw-sys/0.1.4 \
    crate://crates.io/lock_api/0.4.9 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/match_cfg/0.1.0 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/miniz_oxide/0.5.4 \
    crate://crates.io/mio/0.8.5 \
    crate://crates.io/network-interface/0.1.5 \
    crate://crates.io/nix/0.25.1 \
    crate://crates.io/num_cpus/1.14.0 \
    crate://crates.io/object/0.29.0 \
    crate://crates.io/once_cell/1.16.0 \
    crate://crates.io/ordered-stream/0.1.3 \
    crate://crates.io/owo-colors/3.5.0 \
    crate://crates.io/parking/2.0.0 \
    crate://crates.io/parking_lot/0.12.1 \
    crate://crates.io/parking_lot_core/0.9.5 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/polling/2.5.1 \
    crate://crates.io/ppv-lite86/0.2.17 \
    crate://crates.io/proc-macro-crate/1.2.1 \
    crate://crates.io/proc-macro2/1.0.47 \
    crate://crates.io/quote/1.0.21 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/redox_syscall/0.2.16 \
    crate://crates.io/redox_users/0.4.3 \
    crate://crates.io/regex-syntax/0.6.28 \
    crate://crates.io/regex/1.7.0 \
    crate://crates.io/remove_dir_all/0.5.3 \
    crate://crates.io/rustc-demangle/0.1.21 \
    crate://crates.io/rustix/0.36.7 \
    crate://crates.io/ryu/1.0.11 \
    crate://crates.io/scopeguard/1.1.0 \
    crate://crates.io/serde/1.0.149 \
    crate://crates.io/serde_derive/1.0.149 \
    crate://crates.io/serde_json/1.0.92 \
    crate://crates.io/serde_repr/0.1.10 \
    crate://crates.io/sha1/0.10.5 \
    crate://crates.io/sharded-slab/0.1.4 \
    crate://crates.io/signal-hook-registry/1.4.0 \
    crate://crates.io/slab/0.4.7 \
    crate://crates.io/smallvec/1.10.0 \
    crate://crates.io/socket2/0.4.7 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/syn/1.0.105 \
    crate://crates.io/tempfile/3.3.0 \
    crate://crates.io/termcolor/1.2.0 \
    crate://crates.io/thiserror-impl/1.0.37 \
    crate://crates.io/thiserror/1.0.37 \
    crate://crates.io/thread_local/1.1.4 \
    crate://crates.io/tokio-macros/1.8.2 \
    crate://crates.io/tokio-util/0.7.4 \
    crate://crates.io/tokio/1.23.0 \
    crate://crates.io/toml/0.5.10 \
    crate://crates.io/tracing-attributes/0.1.23 \
    crate://crates.io/tracing-core/0.1.30 \
    crate://crates.io/tracing-error/0.2.0 \
    crate://crates.io/tracing-subscriber/0.3.16 \
    crate://crates.io/tracing/0.1.37 \
    crate://crates.io/typenum/1.16.0 \
    crate://crates.io/uds_windows/1.0.2 \
    crate://crates.io/unicode-ident/1.0.5 \
    crate://crates.io/valuable/0.1.0 \
    crate://crates.io/value-bag/1.0.0-alpha.9 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/waker-fn/1.1.0 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.83 \
    crate://crates.io/wasm-bindgen-futures/0.4.33 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.83 \
    crate://crates.io/wasm-bindgen-macro/0.2.83 \
    crate://crates.io/wasm-bindgen-shared/0.2.83 \
    crate://crates.io/wasm-bindgen/0.2.83 \
    crate://crates.io/web-sys/0.3.60 \
    crate://crates.io/wepoll-ffi/0.1.2 \
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
    crate://crates.io/zbus/3.7.0 \
    crate://crates.io/zbus_macros/3.7.0 \
    crate://crates.io/zbus_names/2.5.0 \
    crate://crates.io/zvariant/3.10.0 \
    crate://crates.io/zvariant_derive/3.10.0 \
"
