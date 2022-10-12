package com.kodtodya.practice.controllers;

import com.kodtodya.practice.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @Autowired(required = true)
    private GreetingsService greetingsService;

    @GetMapping("/hello")
    public String controlGreetings(@RequestParam(name = "name", required = false) String name) {
        return greetingsService.sayHello(name);
    }

}
