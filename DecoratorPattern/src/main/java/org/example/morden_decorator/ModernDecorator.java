package org.example.morden_decorator;

import org.example.domain.Request;

import java.util.Map;
import java.util.Objects;

public class ModernDecorator {
    public static void main(String[] args) {
        RequestProcessor baseProcessor = new BaseRequestProcessor();
        RequestProcessor loggingProcessor = new LoggingDecorator();
        RequestProcessor validationDecorator = new ValidationDecorator();

        RequestProcessor pipeLine = (request) -> {};
        RequestProcessor processorPipeline = pipeLine
                .andThen(loggingProcessor::process)
                .andThen(validationDecorator::process)
                .andThen(baseProcessor::process);

        Map<String, String> headers = Map.of("Authorization", "Bearer tokenTest");
        Request validRequest = new Request("192.168.1.1", headers);
        Request invalidRequest = new Request("192.168.1.1", null);

        try {
            processorPipeline.process(validRequest);
            processorPipeline.process(invalidRequest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

@FunctionalInterface
interface RequestProcessor{
    void process(Request request);
    default RequestProcessor andThen(RequestProcessor next){
        return request -> {
            this.process(request);
            next.process(request);
        };
    }
}

class BaseRequestProcessor implements RequestProcessor {
    @Override
    public void process(Request request) {
        System.out.println("Request processed successfully");
    }
}

class LoggingDecorator implements RequestProcessor {

    @Override
    public void process(Request request) {
        System.out.println("Logging request: " +  request);
    }
}

class ValidationDecorator implements RequestProcessor {
    @Override
    public void process(Request request) {
        if(isRequestInvalid(request)){
            throw new IllegalStateException("Invalid Request.");
        }
    }

    private boolean isRequestInvalid(Request request){
        return Objects.isNull(request.headers()) || !request.headers().containsKey("Authorization");
    }
}

