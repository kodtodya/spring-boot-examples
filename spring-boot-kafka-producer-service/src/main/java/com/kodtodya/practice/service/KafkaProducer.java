package com.kodtodya.practice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

	@Value("${topic.name}")
	private String kafkaTopic;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String message) {
		kafkaTemplate.send(kafkaTopic, message);
		logger.info("Posted Message to kafka-topic: '{}' as '{}'", kafkaTopic, message);
	}
}