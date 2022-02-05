#include <iostream>
#include <memory>
#include <grpcpp/server.h>
#include <grpcpp/server_builder.h>
#include <grpcpp/server_context.h>

#include "simple/greet-service.h"

#define _SIMPLE_RECEIVER_ADDRESS_ "0.0.0.0:50051"

// Application entry point.
int main(int argc, char** argv) {
    // Initialize the service.
    org::simple::api::schema::GreetServiceImpl greetService;

    // Give information to the server builder.
    grpc::ServerBuilder builder;
    builder.AddListeningPort(_SIMPLE_RECEIVER_ADDRESS_, grpc::InsecureServerCredentials());
    
    // Register the service.
    builder.RegisterService(&greetService);

    // Build the server.
    std::unique_ptr<grpc::Server> server(builder.BuildAndStart());
    std::cout << "Server listening on " << _SIMPLE_RECEIVER_ADDRESS_ << std::endl;
    
    // Start and wait for client procedural calls.
    server->Wait();

    return 0;
}