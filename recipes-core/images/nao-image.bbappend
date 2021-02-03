FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

CORE_IMAGE_EXTRA_INSTALL += "\
                             boost \
                             bzip2 \
                             libjpeg-turbo \
                             libpng \
                             zlib \
                             alsa-lib \
                             portaudio-v19 \
                             libfftw \
                             libsndfile1 \
                             msgpack-c \
                             libogg \
                             libopus \
                             opusfile \
                             compilednn \
                            "

TOOLCHAIN_TARGET_TASK_append = " libeigen-dev"
