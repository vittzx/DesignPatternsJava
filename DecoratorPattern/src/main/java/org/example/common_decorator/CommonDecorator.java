package org.example.common_decorator;

import org.example.domain.Request;

import java.util.Map;
import java.util.Objects;

public class CommonDecorator {
    public static void main(String[] args) {
        RequestProcessor baseRequestProcessor = new BaseRequestProcessor();
        RequestProcessor validationProcessor = new ValidationDecorator(baseRequestProcessor);
        RequestProcessor loggingProcessor = new LoggingDecorator(validationProcessor);
        RequestProcessor processorPipeLine = loggingProcessor;
        // Simulating request

        Map<String, String> headers = Map.of("Authorization", "Bearer tokenTest");
        Request validRequest = new Request("192.168.1.1", headers);
        Request invalidRequest = new Request("192.168.1.1", null);

        try {
            processorPipeLine.process(validRequest);
            processorPipeLine.process(invalidRequest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

interface RequestProcessor{
    void process(Request request);
}

class BaseRequestProcessor implements RequestProcessor{
    @Override
    public void process(Request request) {
        System.out.println("Request processed successfully");
    }
}

abstract class RequestProcessDecorator implements RequestProcessor {
    protected final RequestProcessor wrappedProcessor;

    public RequestProcessDecorator(RequestProcessor requestProcessor){
        this.wrappedProcessor = requestProcessor;
    }

    @Override
    public void process(Request request) {
        wrappedProcessor.process(request);
    }
}

class LoggingDecorator extends RequestProcessDecorator{
    public LoggingDecorator(RequestProcessor requestProcessor){
        super(requestProcessor);
    }

    @Override
    public void process(Request request) {
        System.out.println("Logging request: " +  request);
        super.process(request);
    }
}

class ValidationDecorator extends RequestProcessDecorator{
    public ValidationDecorator(RequestProcessor requestProcessor){
        super(requestProcessor);
    }

    @Override
    public void process(Request request) {
        if(isRequestInvalid(request)){
            throw new IllegalStateException("Invalid Request.");
        }
        super.process(request);
    }

    private boolean isRequestInvalid(Request request){
        return Objects.isNull(request.headers()) || !request.headers().containsKey("Authorization");
    }
}


