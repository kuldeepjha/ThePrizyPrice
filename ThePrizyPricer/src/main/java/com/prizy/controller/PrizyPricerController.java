package com.prizy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrizyPricerController {


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
