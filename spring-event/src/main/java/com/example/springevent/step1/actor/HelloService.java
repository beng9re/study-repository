package com.example.springevent.step1.actor;

import com.example.springevent.step1.EchoEventPublish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {
    private final EchoEventPublish echoEventPublish;

    public HelloService(EchoEventPublish echoEventPublish) {
        this.echoEventPublish = echoEventPublish;
    }
    void call(String message) {
        log.info("HelloService.call");
        echoEventPublish.publish(message);
        log.info("HelloService.end");
    }
}
