package com.kodtodya.practice.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Lazy
@Scope(value = "singleton")
@Service(value="testService")
@Profile({"local", "default", "dev"})
public class TestService {

    public String sayHello() {
        return "Hello world!!!";
    }
}
