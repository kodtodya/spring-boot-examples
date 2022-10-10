package com.kodtodya.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableEurekaServer
public class InterceptorDemoApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InterceptorDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(InterceptorDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (0 == args.length)
            logger.info("No arguments are provided to this program");
        else
            for (String arg : args)
                logger.info("Argument received: {}", arg);
    }
}
