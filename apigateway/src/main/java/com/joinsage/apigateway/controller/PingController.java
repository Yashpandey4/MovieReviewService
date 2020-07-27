package com.joinsage.apigateway.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ping")
public class PingController {
    @RequestMapping("/")
    public String ping() {
        return "Ping";
    }
}

