cmake_minimum_required(VERSION 3.21)

project(org.simple.api VERSION 0.0.0)

# Compile .proto files into C++ source code.
# (The configure script in the project root directory
# has to have been ran before this could work.)
if (WIN32)
    # Execute the .bat file for windows.
    execute_process(
        COMMAND "${CMAKE_CURRENT_SOURCE_DIR}/compile-protos.bat"
        WORKING_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}"
    )
else()
    execute_process(
        COMMAND "${CMAKE_CURRENT_SOURCE_DIR}/compile-protos"
        WORKING_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}"
    )
endif()

# < ---------- Import protobuf and grpc library ------------ >

# Set flags.
set(protobuf_BUILD_TESTS OFF)
set(protobuf_BUILD_PROTOC_BINARIES OFF)
set(gRPC_PROTOBUF_PROVIDER "module")
set(PROTOBUF_ROOT_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../protobuf")
set(gRPC_BUILD_CODEGEN OFF)
set(gRPC_BUILD_CSHARP_EXT OFF)
# Add grpc cmake subdirectory.
add_subdirectory(
    "${CMAKE_CURRENT_SOURCE_DIR}/../../grpc/"
    "${CMAKE_CURRENT_BINARY_DIR}/grpc/"
)

# < --------------------- END ---------------------------- >

# Define the api implementation library.
file(
    GLOB simple_grpc_api_src
    "${CMAKE_CURRENT_SOURCE_DIR}/src/api/schema/*.cc"
    "${CMAKE_CURRENT_SOURCE_DIR}/src/**.cpp"
)
add_library(
    org.simple.api
    ${simple_grpc_api_src}
)
target_link_libraries(
    org.simple.api PUBLIC
    libprotobuf-lite
    grpc
)
target_include_directories(
    org.simple.api PUBLIC
    "${CMAKE_CURRENT_SOURCE_DIR}/src/"
)