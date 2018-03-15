package com.avadhut.spring.boot.serviceControllers;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ArtemisProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void send(String msg) {

		try {
			 jmsTemplate.send(new MessageCreator(){
				 @Override
				public Message createMessage(Session session) throws JMSException {
				        TextMessage message = session.createTextMessage();
                        message.setText(msg);
                        return message;
				}
			});
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}