package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestController는 REST API를 처리하는 Controller
@RequestMapping("/api") // RequestMapping은 URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello") // http://localhost:8080/api/hello
    public String hello() {
        return "Hello, Spring boot!!";
    }

}
