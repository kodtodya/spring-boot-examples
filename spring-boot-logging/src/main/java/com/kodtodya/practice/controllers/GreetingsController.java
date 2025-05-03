package com.kodtodya.practice.controllers;

import com.kodtodya.practice.services.GreetingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    private Logger logger = LoggerFactory.getLogger(GreetingsController.class);

    @Autowired
    private GreetingsService greetingsService;

    @GetMapping("/hello")
    public String controlGreetings(@RequestParam(name = "name", required = false) String name) {
        logger.debug("/hello - request received - {}", name);
        String response = greetingsService.sayHello(name);
        logger.debug("responding back to /hello - response: {}", response);
        return response;
    }
}
