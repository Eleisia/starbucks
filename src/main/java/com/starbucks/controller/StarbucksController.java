package com.starbucks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StarbucksController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "HELLO WORLD";
    }
}
