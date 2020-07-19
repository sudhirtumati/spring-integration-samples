package com.sudhirt.practice.integration.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.jms.dsl.Jms;

import javax.jms.ConnectionFactory;

@Configuration
public class ProducerConfig {

    private final ConnectionFactory connectionFactory;

    public ProducerConfig(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public IntegrationFlow outboundFlow() {
        return IntegrationFlows.from("helloChannel")
                .log()
                .handle(Jms.outboundAdapter(connectionFactory)
                        .destination("helloMQ"))
                .get();
    }
}
