cmake_minimum_required(VERSION 3.21)

project(org.simple.receiver VERSION 0.0.0)

# Define the executable.
file(GLOB simple_src
     "${CMAKE_CURRENT_SOURCE_DIR}/src/*.cpp"
)
add_executable(
    org.simple.receiver
    ${simple_src}
)