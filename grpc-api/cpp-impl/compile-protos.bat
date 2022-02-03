@rem This script compiles .proto files from the
@rem folder ..\schema\

@rem Make sure the output folder exists.
if not exist src\api\schema\ (
mkdir src\api\schema\
)

@rem Generate messages implementation.
..\bin\protoc.exe ^
--proto_path=..\schema\ ^
--cpp_out=src\api\schema\ ^
..\schema\*.proto
@rem Generate grpc service implementation.
..\bin\protoc.exe ^
--plugin=protoc-gen-grpc=..\bin\grpc_cpp_plugin.exe ^
--proto_path=..\schema\ ^
--grpc_out=src\api\schema\ ^
..\schema\*.proto