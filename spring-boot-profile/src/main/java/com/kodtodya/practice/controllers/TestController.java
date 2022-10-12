package com.kodtodya.practice.controllers;

import com.kodtodya.practice.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile({"local", "default", "dev"})
public class TestController {

    @Autowired(required = true)
    private TestService testService;

    @GetMapping("/hello-world")
    public String controlGreetings() {
        return testService.sayHello();
    }

}
