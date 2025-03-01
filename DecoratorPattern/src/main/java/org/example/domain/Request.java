package org.example.domain;

import java.util.Map;

public record Request(
        String ip,
        Map<String, String> headers
) {
}
