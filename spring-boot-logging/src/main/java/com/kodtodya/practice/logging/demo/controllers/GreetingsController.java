package com.kodtodya.practice.logging.demo.controllers;

import com.kodtodya.practice.logging.demo.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @Autowired
    private GreetingsService greetingsService;

    @GetMapping(value = "/hello")
    public String controlGreetings(@RequestParam(name = "name", required = false) String name) {
        return greetingsService.sayHello(name);
    }

}
