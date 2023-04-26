FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SDK_ZSTD_COMPRESSION_LEVEL = "-9"

CORE_IMAGE_EXTRA_INSTALL += " \
                              alsa-lib \
                              alsa-state \
                              compilednn \
                              hula \
                              hulk \
                              sounds \
                              aliveness \
                              jq \
                              libxml2-utils \
                              nano \
                              network-config \
                              iproute2 \
                            "
