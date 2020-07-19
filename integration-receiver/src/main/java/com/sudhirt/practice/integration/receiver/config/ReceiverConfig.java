package com.sudhirt.practice.integration.receiver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.jms.dsl.Jms;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.jms.ConnectionFactory;

@Configuration
@EnableAsync
public class ReceiverConfig {

    private final ConnectionFactory connectionFactory;

    public ReceiverConfig(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public IntegrationFlow inboundFlow() {
        return IntegrationFlows.from(Jms.messageDrivenChannelAdapter(connectionFactory).destination("helloMQ"))
                .channel("helloChannel")
                .handle("messageProcessor", "process")
                .get();
    }

}
