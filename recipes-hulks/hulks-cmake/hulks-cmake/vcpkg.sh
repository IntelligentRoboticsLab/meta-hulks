#!/bin/bash

set -e

rm -Rf build/vcpkg
mkdir -p build/vcpkg
cmake -G Ninja -DCMAKE_TOOLCHAIN_FILE=/home/hendrik/vcpkg/scripts/buildsystems/vcpkg.cmake -DVCPKG_OVERLAY_PORTS="${PWD}/vcpkg-ports" -Bbuild/vcpkg -S.
cmake --build build/vcpkg
build/vcpkg/hulks-cmake
