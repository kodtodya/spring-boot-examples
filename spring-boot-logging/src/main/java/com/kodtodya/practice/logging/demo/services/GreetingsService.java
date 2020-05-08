package com.kodtodya.practice.logging.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Lazy
@Scope(value = "singleton")
@Service(value="greetingsService")
public class GreetingsService {

    @Value(value="${generic.greeting}")
    private String genericGreeting;

    public String sayHello(String name) {
        return genericGreeting + name;
    }
}
