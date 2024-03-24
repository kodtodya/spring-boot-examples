package com.kodtodya.practice.controllers;

import com.kodtodya.practice.services.GreetingsService;
import com.kodtodya.practice.services.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {

    private Logger logger = LoggerFactory.getLogger(GreetingsController.class);
    @Autowired(required = true)
    private GreetingsService greetingsService;

    @GetMapping("/hello")
    public String controlGreetings(@RequestParam(name = "name", required = false) String name) {
        logger.trace("i came to /hello controller");
        return greetingsService.sayHello(name);
    }

}
