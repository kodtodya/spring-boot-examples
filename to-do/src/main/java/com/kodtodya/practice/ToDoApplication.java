package com.kodtodya.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kodtodya.practice")
public class ToDoApplication {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/to-do");
        SpringApplication.run(ToDoApplication.class);
    }
}