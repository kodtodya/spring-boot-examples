package com.kodtodya.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableCaching(order = 3)
public class AspectOrientedProgrammingDemo {

    public static void main(String[] args) {
        SpringApplication.run(AspectOrientedProgrammingDemo.class, args);
    }
}
