package com.example.springevent.step3_anotation.actor;

import com.example.springevent.step3_anotation.AnnotationBasedEchoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnnotationBasedHelloService {

    private final ApplicationEventPublisher publisher;

    void call() {
        log.info("AnnotationBasedHelloService.call");
        AnnotationBasedEchoEvent event = new AnnotationBasedEchoEvent(this, "메시지");
        publisher.publishEvent(event);
        //asyncEchoEventPublish.publish("비동기 hello");
        log.info("AnnotationBasedHelloService.end");
    }
}
