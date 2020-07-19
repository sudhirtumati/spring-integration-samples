package com.sudhirt.practice.integration.producer.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface HelloGateway {

    @Gateway(requestChannel = "helloChannel")
    void send(String message);
}
