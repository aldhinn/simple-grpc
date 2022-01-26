@rem Update submodules
call git submodule update --init --recursive

@rem Check if the Java output directory exists.
if not exist grpc-api\java-impl\src\ (
@rem If it doesn't exist, create it.
call mkdir grpc-api\java-impl\src
)

@rem Generate Java source code for the grpc protobuf schema.
call protoc --proto_path=grpc-api\schema --java_out=grpc-api\java-impl\src grpc-api\schema\*.proto

@rem Check if the C++ output directory exists.
if not exist grpc-api\cpp-impl\src\schema\ (
@rem If it doesn't exist, create it.
call mkdir grpc-api\cpp-impl\src\schema
)

@rem Generate c++ source code for the grpc protobuf schema
call protoc --proto_path=grpc-api\schema --cpp_out=grpc-api\cpp-impl\src\schema grpc-api\schema\*.proto
