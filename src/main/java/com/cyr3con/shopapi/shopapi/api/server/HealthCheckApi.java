package com.cyr3con.shopapi.shopapi.api.server;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

public class HealthCheckApi {

    @GetMapping(value = "/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String healthCheck() {
        return "UP";
    }
}
