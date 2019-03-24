package com.kodtodya.practice.angular.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@SpringBootApplication
public class AngularSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularSpringBootApplication.class, args);
	}

	/*@RequestMapping("/")
	public String greet(){
		return "Hello world..!!!";
	}*/

}
