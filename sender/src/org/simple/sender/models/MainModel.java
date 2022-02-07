package org.simple.sender.models;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.simple.api.schema.GreetResponse;
import org.simple.api.schema.Greeting;
import org.simple.api.schema.GreetServiceGrpc;
import org.simple.api.schema.GreetServiceGrpc.GreetServiceBlockingStub;

import java.util.concurrent.TimeUnit;

public class MainModel {
    //#region sendMessage
    public void sendMessage(String message) {
        // A lot of this is copied from here:
        // https://github.com/grpc/grpc-java/blob/master/examples/src/main/java/io/grpc/examples/helloworld/HelloWorldClient.java

        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget("0.0.0.0:50051")
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();

        GreetServiceBlockingStub blockingStub = GreetServiceGrpc.newBlockingStub(channel);

        try {
            Greeting greeting = Greeting.newBuilder().setText(message).build();
            GreetResponse greetResponse = blockingStub.sendGreeting(greeting);
        }
        catch (StatusRuntimeException exception) {
            System.out.println("RPC failed: " +exception.getStatus());
        }
        finally {
            try {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            }
            catch (Exception ex) {
                // Do nothing.
            }
        }
    }
    //#endregion
}