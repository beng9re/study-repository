package com.example.springevent.step1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EchoEventListener implements ApplicationListener<EchoEvent> {

    @Override
    public void onApplicationEvent(EchoEvent event) {
        log.info("안녕 이벤트 {}", event.getMessage());
    }
}
