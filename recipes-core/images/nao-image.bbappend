FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

CORE_IMAGE_EXTRA_INSTALL += "\
                             alsa-lib \
                             alsa-state \
                             boost \
                             bzip2 \
                             compilednn \
                             fftw \
                             hulk \
                             jq \
                             libjpeg-turbo \
                             libogg \
                             libopus \
                             libpng \
                             libsndfile1 \
                             libxml2-utils \
                             msgpack-c \
                             nano \
                             network-config \
                             aliveness \
                             opusfile \
                             zlib \
                            "

TOOLCHAIN_TARGET_TASK_append = " libeigen-dev"
