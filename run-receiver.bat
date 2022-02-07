@rem Go to the receiver directory
cd receiver

@rem Create the build directory if it doesn't exist yet.
if not exist build\ (
mkdir build\
)

@rem Go to the build directory.
cd build

@rem Check if the receiver is already built.
if not exist org.simple.receiver.exe (
@rem Create the project files using cmake.
cmake ..\
@rem Build the binaries.
cmake --build .
)

@rem Execute.
org.simple.receiver.exe