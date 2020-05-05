package com.kodtodya.practice.logging_demo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingsService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
