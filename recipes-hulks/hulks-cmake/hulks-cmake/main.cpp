#include <fftw3.h>
#include <Eigen/Dense>
#include <iostream>
#include <jpeglib.h>
#include <zlib.h>
#include <png.h>
#include <pthread.h>
#include <CompiledNN/CompiledNN.h>

int main() {
  fftw_cleanup();
  std::cout << "zlib version: " << zlibVersion() << '\n';
  struct jpeg_compress_struct cinfo;
  struct jpeg_error_mgr jerr;
  cinfo.err = jpeg_std_error(&jerr);
  Eigen::MatrixXd m{2, 2};
  std::cout << m << '\n';
  png_structp png{png_create_read_struct(PNG_LIBPNG_VER_STRING, NULL, NULL, NULL)};
  pthread_self();
  NeuralNetwork::Model model;
  std::cout << "ok\n";
  return 0;
}
