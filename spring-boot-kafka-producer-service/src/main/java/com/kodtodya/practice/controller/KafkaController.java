package com.kodtodya.practice.controller;

import com.kodtodya.practice.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

	@Autowired
	private KafkaProducer producer;
	
	@PostMapping(value="/send")
	public String sendToKafka(@RequestBody String message) {
		producer.send(message);
		return "Message sent to Kafka topic..";
	}

	@GetMapping(value="/hi")
	public String greet() {
		return "Hello Avadhut..!!";
	}
}
