package com.example.springevent.step4_customTreadPool;

import com.example.springevent.step3_anotation.AnnotationBasedEchoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomThreadPoolEventListener {

    @Async("asyncExecutor")
    public void onApplicationEvent(AnnotationBasedEchoEvent event) {
        log.info("비동기 풀 이벤트 {}", event.getMessage());
    }
}
