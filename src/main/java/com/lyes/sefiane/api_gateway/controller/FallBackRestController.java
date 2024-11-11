package com.lyes.sefiane.api_gateway.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackRestController {

    /**
     * Throw Exception Instead.
     */
    @GetMapping("/service-unavailable")
    ResponseEntity<String> serviceUnavailableFallback() {
        return new ResponseEntity<>("We are sorry! The service is currently unavailable. \nPlease try later",
                HttpStatusCode.valueOf(503));
    }

}
