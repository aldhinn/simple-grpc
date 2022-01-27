cmake_minimum_required(VERSION 3.21)

project(org.simple.api VERSION 0.0.0)

# Prevent protobuf tests from running.
set(protobuf_BUILD_TESTS OFF)
# Prevent protoc binaries from being built.
set(protobuf_BUILD_PROTOC_BINARIES OFF)
# Import protobuf library
add_subdirectory(
    "${CMAKE_CURRENT_SOURCE_DIR}/../../protobuf/cmake"
    "${CMAKE_CURRENT_BINARY_DIR}/protobuf/"
)

# Define the executable.
file(GLOB simple_grpc_api_src
    "${CMAKE_CURRENT_SOURCE_DIR}/src/**/*.cc"
    "${CMAKE_CURRENT_SOURCE_DIR}/src/**/*.cpp"
)
add_library(
    org.simple.api
    ${simple_grpc_api_src}
)
target_link_libraries(
    org.simple.api PUBLIC
    libprotobuf
    libprotoc
)