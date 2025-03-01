package org.example.no_pattern;

import org.example.domain.Request;

import java.util.Map;
import java.util.Objects;

public class NoPattern {
    public static void main(String[] args) {
        RequestProcessor processor = new RequestProcessor();

        // Simulating request

        Map<String, String> headers = Map.of("Authorization", "Bearer tokenTest");
        Request validRequest = new Request("192.168.1.1", headers);
        Request invalidRequest = new Request("192.168.1.1", null);
        try {
            processor.process(validRequest);
            processor.process(invalidRequest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class RequestProcessor{
    public void process(Request request){
        // Logging
        System.out.println("Logging request: " +  request);


        // Validation
        if(isRequestInvalid(request)){
            throw new IllegalStateException("Invalid Request.");
        }

        //Actual processing
        System.out.println("Request processed successfully");

    }

    private boolean isRequestInvalid(Request request){
        return Objects.isNull(request.headers()) || !request.headers().containsKey("Authorization");
    }
}
