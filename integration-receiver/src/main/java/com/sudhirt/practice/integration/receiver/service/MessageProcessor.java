package com.sudhirt.practice.integration.receiver.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageProcessor {

    @Async
    public void process(String message) {
        log.info("Message: {} Received. Processing....", message);
        try {
            Thread.sleep(10000);
            log.info("Message: {} processed successfully", message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
