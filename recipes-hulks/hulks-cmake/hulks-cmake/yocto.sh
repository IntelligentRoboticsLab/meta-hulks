#!/bin/bash

set -e

. /opt/Nao-OS/0.4/environment-setup-corei7-64-poky-linux

echo OECORE_TARGET_SYSROOT: ${OECORE_TARGET_SYSROOT}

# SET_RPATH=''
# if [ $OPT_NO_RPATH -ne 1 ] ; then
#     SET_RPATH="-DCMAKE_INSTALL_RPATH=\"${OECORE_TARGET_SYSROOT}/lib:${OECORE_TARGET_SYSROOT}/usr/lib\" -DCMAKE_BUILD_WITH_INSTALL_RPATH=TRUE -DCMAKE_EXE_LINKER_FLAGS=\"-Wl,--dynamic-linker=${OECORE_TARGET_SYSROOT}/lib/ld-linux.so.2\""
#     export LD_LIBRARY_PATH="${OECORE_TARGET_SYSROOT}/lib:${OECORE_TARGET_SYSROOT}/usr/lib"
# fi

# cmake -G Ninja -H"${COMPONENT_DIR}" -B${BUILD_TARGET_DIR} -DCMAKE_INSTALL_PREFIX=/usr -DCMAKE_BUILD_TYPE=$OPT_BUILD_TYPE ${CMAKE_OPTIONS} ${SET_RPATH}

rm -Rf build/yocto
mkdir -p build/yocto
cmake -G Ninja -Bbuild/yocto -DCMAKE_INSTALL_RPATH="${OECORE_TARGET_SYSROOT}/lib64:${OECORE_TARGET_SYSROOT}/usr/lib64" -DCMAKE_BUILD_WITH_INSTALL_RPATH=TRUE -DCMAKE_EXE_LINKER_FLAGS="-Wl,--dynamic-linker=${OECORE_TARGET_SYSROOT}/lib64/ld-linux-x86-64.so.2" -S.
cmake --build build/yocto
LD_LIBRARY_PATH="${OECORE_TARGET_SYSROOT}/lib64:${OECORE_TARGET_SYSROOT}/usr/lib64" build/yocto/hulks-cmake
