FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://github.com/HULKs/CompiledNN.git;branch=thinterface;protocol=https"

SRCREV = "00cac199e1a00bd11d8301883fdac5d2b1e123e6"

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON -DWITH_ONNX=OFF"
