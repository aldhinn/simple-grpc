#if _GREET_SERVICE_HEADER_ != 1
#define _GREET_SERVICE_HEADER_ 1

#include "api/schema/greet.grpc.pb.h"

namespace org::simple::api::schema {
    // The implementation of the Greet Service.
    class GreetServiceImpl : public GreetService::Service {
        public:
        // Handles the send greeting request from the clients.
        grpc::Status sendGreeting(
            grpc::ServerContext* context,
            const Greeting* request,
            GreetResponse* response
        ) override;
    };
}

#endif
// END of File.
// DO NOT WRITE BEYOND HERE!