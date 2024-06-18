package com.example.basic.controller;

import com.example.basic.dto.PutRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put")
    public PutRequest put(@RequestBody PutRequest requestData) {
        System.out.println(requestData);

        return requestData;
    }

    @PutMapping("/put/{userId}")
    public PutRequest put(@RequestBody PutRequest requestData, @PathVariable Long userId) {
        System.out.println(userId);

        return requestData;
    }

}
