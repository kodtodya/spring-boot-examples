package com.avadhut.spring.boot.ArtemisService;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.avadhut.spring.boot.serviceControllers.ArtemisConsumer;


@SpringBootApplication
@ImportResource({"classpath:spring/spring-context.xml"})
@ComponentScan(basePackages="com.avadhut.spring.boot.serviceControllers")
public class ArtemisService {

	@Autowired
	private static ArtemisConsumer consumer;
	
	public static void main(String[] args) throws JMSException, InterruptedException {
		SpringApplication.run(ArtemisService.class, args);
		
		System.out.println("starting consumer");
		
		consumer.receiveMessage();
		

	}

	public static void setConsumer(ArtemisConsumer consumer) {
		ArtemisService.consumer = consumer;
	}

}