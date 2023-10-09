package com.example.springevent.step5_orderedEvent.actor;

import com.example.springevent.step5_orderedEvent.OrderedEchoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderedHelloService {
    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderedHelloService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    void call() {
        log.info("OrderedHelloService.call");
        OrderedEchoEvent orderedEchoEvent = new OrderedEchoEvent(this, "순서 메시지");
        applicationEventPublisher.publishEvent(orderedEchoEvent);
        log.info("OrderedHelloService.end");
    }
}
