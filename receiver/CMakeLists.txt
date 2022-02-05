cmake_minimum_required(VERSION 3.21)

project(org.simple.receiver VERSION 0.0.0)

# Add grpc c++ implementation project module.
add_subdirectory(
    "${CMAKE_CURRENT_SOURCE_DIR}/../grpc-api/cpp-impl/"
    "${CMAKE_CURRENT_BINARY_DIR}/grpc-api-cpp-impl/"
)

# Define the executable.
file(GLOB simple_src
     "${CMAKE_CURRENT_SOURCE_DIR}/src/*.cpp"
)
add_executable(
    org.simple.receiver
    ${simple_src}
)
target_link_libraries(
    org.simple.receiver
    org.simple.api
)