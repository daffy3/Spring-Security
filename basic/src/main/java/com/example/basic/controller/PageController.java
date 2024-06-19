package com.example.basic.controller;

import com.example.basic.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    // ResponseEntity

    // ResponseBody로 조회하겠다.
    @ResponseBody
    @GetMapping("/user")
    public UserDto user(){
        var user = new UserDto();

        user.setName("9Diin");
        user.setAddress("서울특별시 관악구");

        return user;
    }
}
