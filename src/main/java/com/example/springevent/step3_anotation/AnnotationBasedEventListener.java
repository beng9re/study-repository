package com.example.springevent.step3_anotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnnotationBasedEventListener {

    @EventListener(AnnotationBasedEchoEvent.class)
    public void onApplicationEvent(AnnotationBasedEchoEvent event) {
        log.info("어노테이션 이벤트 {}", event.getMessage());
    }
}
