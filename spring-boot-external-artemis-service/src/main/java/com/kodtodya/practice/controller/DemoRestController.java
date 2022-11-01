package com.kodtodya.practice.controller;

import com.kodtodya.practice.service.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoRestController {

	@Autowired
	private JmsProducer producer;
	
	@PostMapping(value="/send")
	public String sendToJms(@RequestBody String message) {
		producer.send(message);
		return "Message sent to Queue..";
	}

	@GetMapping(value="/hi")
	public String greet() {
		return "Hello Avadhut..!!";
	}
}
