package com.kodtodya.sessions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableEurekaServer
public class InterceptorDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InterceptorDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(0 == args.length)
			System.out.println("No arguments are provided to this program");
		else
			for(String arg:args)
				System.out.println("Argument received: " +arg);
	}
}
