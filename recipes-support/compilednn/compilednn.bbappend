FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://github.com/HULKs/CompiledNN.git;branch=thinterface_cross;protocol=https"

SRCREV = "b8cb473ce7a92caddf87fe9eb03cf68ab4735dab"

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON -DWITH_ONNX=OFF"
