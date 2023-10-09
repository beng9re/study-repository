package com.example.springevent.step1;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 *
 *  이벤트를 발행 한다.
 * */
@Component
public class EchoEventPublish {
    private final ApplicationEventPublisher applicationEventPublisher;

    public EchoEventPublish(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(String message) {
        applicationEventPublisher.publishEvent(new EchoEvent(this, message));
    }

}
