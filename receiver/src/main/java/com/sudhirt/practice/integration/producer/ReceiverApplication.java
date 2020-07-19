package com.sudhirt.practice.integration.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReceiverApplication {

    @Autowired
    private MessageReceiver receiver;

    public static void main(String[] args) {
        SpringApplication.run(ReceiverApplication.class, args);
    }

}
