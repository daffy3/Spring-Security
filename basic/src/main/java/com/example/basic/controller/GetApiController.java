package com.example.basic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // 명시적으로 path 설정
    @GetMapping(path = "/hello") // http://localhost:8080/api/get/hello
    public String getHello() {
        return "GET Hello, Spring boot!!";
    }

    // @RequestMapping("/hi") // GET / POST / PUT / DELETE 모든 메서드가 매핑이 되기 때문에
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get - http://localhost:8080/api/get/hi
    public String hi() {
        return "GET Hi, Spring boot!";
    }

    // http://localhost:8080/api/get 까지는 고정
    // http://localhost:8080/api/get/path-variable/{name}
    // 주소에 대문자는 사용하지 않는다.

    // Path Variable은 어떻게 받을까?
    // Path Variable의 변하는 부분을 괄호를 쳐준다.
    // @PathVariable의 변수의 이름과 GetMapping의 이름이 같아야 한다. ex) name

    // 방식 1
    @GetMapping("/path-variable/{name}")
    public String pathVariable1(@PathVariable String name) {
        System.out.println("PathVariable: " + name);
        return name;
    }

    // 방식 2
    @GetMapping("/path-variable/{name}")
    public String pathVariable2(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable: " + pathName);
        return pathName;
    }

    // Query Parameter
    // 첫 Query는 ?로 key-value
    // 그 이후로부터는 &key-value
    // http://localhost:8080/api/get/query-parameter?user=steve&email=steve@gmail.com&age=30

}
