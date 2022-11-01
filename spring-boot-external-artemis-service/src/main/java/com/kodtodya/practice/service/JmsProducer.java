package com.kodtodya.practice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsProducer {

	Logger log = LoggerFactory.getLogger(JmsProducer.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String message) {
		jmsTemplate.convertAndSend(message);
		log.info("Sent message='{}'", message);
	}
}