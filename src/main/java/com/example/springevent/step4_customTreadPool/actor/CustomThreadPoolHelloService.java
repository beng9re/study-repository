package com.example.springevent.step4_customTreadPool.actor;

import com.example.springevent.step4_customTreadPool.CustomThreadPoolEchoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomThreadPoolHelloService {

    private final ApplicationEventPublisher publisher;

    void call() {
        log.info("CustomThreadPoolHelloService.call");
        CustomThreadPoolEchoEvent event = new CustomThreadPoolEchoEvent(this, "메시지");
        publisher.publishEvent(event);
        log.info("CustomThreadPoolHelloService.end");
    }
}
