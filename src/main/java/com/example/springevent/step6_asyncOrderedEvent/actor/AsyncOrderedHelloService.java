package com.example.springevent.step6_asyncOrderedEvent.actor;

import com.example.springevent.step6_asyncOrderedEvent.AsyncOrderedEchoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncOrderedHelloService {
    private final ApplicationEventPublisher applicationEventPublisher;

    public AsyncOrderedHelloService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    void call() {
        log.info("asyncOrderedEchoEvent.call");
        AsyncOrderedEchoEvent asyncOrderedEchoEvent = new AsyncOrderedEchoEvent(this, "순서 메시지");
        applicationEventPublisher.publishEvent(asyncOrderedEchoEvent);
        log.info("asyncOrderedEchoEvent.end");
    }
}
