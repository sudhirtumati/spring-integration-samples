package com.sudhirt.practice.integration.producer;

import com.sudhirt.practice.integration.producer.gateway.HelloGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class IntegrationProducerApplication implements CommandLineRunner {

    @Autowired
    private HelloGateway helloGateway;

    public static void main(String[] args) {
        SpringApplication.run(IntegrationProducerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Stream.iterate(0, i -> i + 1).forEach(i -> {
            helloGateway.send("hello " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
