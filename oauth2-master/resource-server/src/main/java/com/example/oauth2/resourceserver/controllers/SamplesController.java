package com.example.oauth2.resourceserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SamplesController {

    @GetMapping("/samples")
    public String[] getSamples() {
        return new String[]{"Sample 1", "Sample 2", "Sample 3"};
    }
}