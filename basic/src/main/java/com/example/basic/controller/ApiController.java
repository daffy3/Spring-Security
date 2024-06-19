package com.example.basic.controller;

import com.example.basic.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // RestController는 REST API를 처리하는 Controller
@RequestMapping("/api") // RequestMapping은 URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello") // http://localhost:8080/api/hello
    public String hello() {
        return "Hello, Spring boot!!";
    }

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // JSON
    // request 요청이 오면 object mapper를 통해 object로 바뀌고 method를 통해 response를 object로 보내고 object mapper를 통해 최종적으로 json으로 보낸다.
    @PostMapping("/json")
    public UserDto json(@RequestBody UserDto user) {
        return user; // 200 OK
    }

    // respone를 보내줄 때, http status 값을 같이 전해줄 경우
    // ResponseEntity 활용하는 방법을 추천!
    @PutMapping("/put-user")
    public ResponseEntity<UserDto> put(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
