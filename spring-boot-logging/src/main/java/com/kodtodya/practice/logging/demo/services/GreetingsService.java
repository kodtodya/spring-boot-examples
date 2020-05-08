package com.kodtodya.practice.logging.demo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingsService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
