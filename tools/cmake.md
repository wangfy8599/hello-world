# CMake Usage
```
mkdir build
cd build
cmake ..
cmake --build .
cmake -DCMAKE_INSTALL_PREFIX=< install_path > ..
```


# CMake Default Variables

CMAKE_SOURCE_DIR
  - the source directory (i.e. the directory of the top level
    CMakeLists.txt file)

CMAKE_BINARY_DIR
  - the (top level) build directory

CMAKE_CURRENT_SOURCE_DIR
  - the current source directory, i.e. location of the currently processed
    CMakeLists.txt file (top level or included via ADD_SUBDIRECTORY)

CMAKE_CURRENT_BINARY_DIR
  - the build (sub)directory corresponding to CMAKE_CURRENT_SOURCE_DIR
