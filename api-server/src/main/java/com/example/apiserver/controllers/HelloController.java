package com.example.apiserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    public HelloController() {
    }

    @GetMapping
    public String hello() {
        return "Hello world!";
    }
}
