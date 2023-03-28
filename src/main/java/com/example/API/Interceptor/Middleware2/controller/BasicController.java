package com.example.API.Interceptor.Middleware2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class BasicController {

    @GetMapping("")
    public String sayHello(){
        return "Hello users!";
    }

}
