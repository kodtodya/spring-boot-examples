package com.kodtodya.practice.logging_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoggingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (args.length > 0) {
            System.out.println("We have received below command line arguments");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No argument parameters received.");
        }
    }
}
