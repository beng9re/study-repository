package com.example.springevent.step2_asyncEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 *
 *  이벤트를 발행 한다.
 * */
@Component
public class AsyncEchoEventPublish {
    private final ApplicationEventPublisher applicationEventPublisher;

    public AsyncEchoEventPublish(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(String message) {
        applicationEventPublisher.publishEvent(new AsyncEchoEvent(this, message));
    }

}
