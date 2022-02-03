@rem Windows Project Configuration Script

@rem Always call this configuration script from the
@rem root of the protject directory.

@rem Update submodules
call git submodule update --init --recursive

@rem <------- Building Protoc and GRPC C++ Plugin ------------>

@rem Create build directory for grpc plugin if it doesn't exist yet.
if not exist grpc-api\build\ (
call mkdir grpc-api\build\
)

@rem Build plugin using cmake.
call cd grpc-api\build\
call cmake ^
-DgRPC_PROTOBUF_PROVIDER=module ^
-Dprotobuf_BUILD_TESTS=OFF ^
-DPROTOBUF_ROOT_DIR=%CD%\..\..\protobuf ^
-DgRPC_BUILD_CSHARP_EXT=OFF ^
-DgRPC_BUILD_GRPC_CSHARP_PLUGIN=OFF ^
-DgRPC_BUILD_GRPC_NODE_PLUGIN=OFF ^
-DgRPC_BUILD_GRPC_OBJECTIVE_C_PLUGIN=OFF ^
-DgRPC_BUILD_GRPC_PHP_PLUGIN=OFF ^
-DgRPC_BUILD_GRPC_PYTHON_PLUGIN=OFF ^
-DgRPC_BUILD_GRPC_RUBY_PLUGIN=OFF ^
..\..\grpc\
call cmake --build . --config Release

@rem Return to the root of the project.
call cd ..\..\

@rem <---------------------- END --------------------->

@rem <------- Copy binaries to grpc-api\bin\ --------->

@rem Ensure grpc-api\bin\ directory exists.
if not exist grpc-api\bin\ (
call mkdir grpc-api\bin\
)

@rem Copy binaries needed.
call copy grpc-api\build\third_party\protobuf\Release\protoc.exe grpc-api\bin\
call copy grpc-api\build\Release\grpc_cpp_plugin.exe grpc-api\bin\

@rem <---------------------- END -------------------->