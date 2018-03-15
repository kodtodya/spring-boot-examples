package com.avadhut.spring.boot.serviceControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RequestMapping
@RestController
public class AMQClientController {

	@Autowired
	ArtemisProducer producer;
	
	@RequestMapping(value="/producer",method = RequestMethod.POST)
	public String produce(@RequestParam("message")String msg){
		producer.send(msg);
		return "Message sent to Queue..";
	}
	
	
	
}
