package com.example.springevent.step2_asyncEvent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncEchoEventListener implements ApplicationListener<AsyncEchoEvent> {

    @Override
    public void onApplicationEvent(AsyncEchoEvent event) {
        log.info("안녕 이벤트 {}", event.getMessage());
    }
}
