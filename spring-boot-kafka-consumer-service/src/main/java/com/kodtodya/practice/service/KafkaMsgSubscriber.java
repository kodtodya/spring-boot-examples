package com.kodtodya.practice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class KafkaMsgSubscriber {

    private Logger logger = LoggerFactory.getLogger(KafkaMsgSubscriber.class);

    @Value("${kafka-group}")
    private String kafkaGroup;

    private CountDownLatch latch = new CountDownLatch(3);

    @KafkaListener(topics = "${topic.name}", containerFactory = "kafkaListenerContainerFactory", topicPartitions = @TopicPartition(topic = "${topic.name}", partitions = { "0" }))
    public void listenGroupFoo(String message) {
        logger.info("Received Message in group '{}' as '{}'", kafkaGroup, message);
        latch.countDown();
    }
}