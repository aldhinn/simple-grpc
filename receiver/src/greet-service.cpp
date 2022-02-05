#include <iostream>

#include "simple/greet-service.h"

namespace org::simple::api::schema {
    grpc::Status GreetServiceImpl::sendGreeting(
            grpc::ServerContext* context,
            const Greeting* request,
            GreetResponse* response
    ) {
        // Simply Print the greeting request text.
        std::cout << "Greeting Received: ";
        std::cout << request->text() << std::endl;

        // Send a success state.
        response->set_state(GreetResponseState::SUCCESS);

        // Return an ok status code.
        return grpc::Status::OK;
    }
}