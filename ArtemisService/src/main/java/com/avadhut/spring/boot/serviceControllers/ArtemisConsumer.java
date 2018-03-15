package com.avadhut.spring.boot.serviceControllers;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void receiveMessage() throws JMSException, InterruptedException {

		System.err.println("consumer started");
		while (true) {
			TextMessage textMessage;
			textMessage = (TextMessage) jmsTemplate.receive();
			if (null == textMessage) {
				Thread.sleep(1000);
			} else {
				System.out.println("Message recived:" + textMessage.getText());
			}
		}

	}
}