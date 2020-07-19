package com.sudhirt.practice.integration.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @Autowired
    public JmsTemplate jmsTemplate;

    @JmsListener(destination = "helloMQ")
    public void processMessage(String message) {
        System.out.println(message);
    }
}
