cmake_minimum_required(VERSION 3.16)
project(hulks-cmake)

find_package(FFTW3 REQUIRED)
find_package(ZLIB REQUIRED)
find_package(JPEG REQUIRED)
find_package(Eigen3 3.3 REQUIRED)
find_package(portaudio REQUIRED)
find_package(PNG REQUIRED)
find_package(opusfile REQUIRED)
find_package(Threads REQUIRED)
find_package(Boost REQUIRED)
find_package(CompiledNN REQUIRED)

add_executable(hulks-cmake
  main.cpp
)

target_link_libraries(hulks-cmake PRIVATE
  FFTW3::fftw3
  ZLIB::ZLIB
  JPEG::JPEG
  Eigen3::Eigen
  portaudio::portaudio
  PNG::PNG
  opusfile::opusfile
  Threads::Threads
  Boost::headers
  CompiledNN::CompiledNN
  ${CMAKE_DL_LIBS}
)

install(TARGETS hulks-cmake
  RUNTIME DESTINATION "${CMAKE_INSTALL_BINDIR}"
)
