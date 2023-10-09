package com.example.springevent.step6_asyncOrderedEvent;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncOrderedEventListener {


    @Async
    @EventListener(AsyncOrderedEchoEvent.class)
    public void oneEvent(AsyncOrderedEchoEvent event) {
        log.info("첫번째 이벤트 {}", event.getMessage());
    }

    @Async
    @EventListener(AsyncOrderedEchoEvent.class)
    public void twoEvent(AsyncOrderedEchoEvent event) throws InterruptedException {

        log.info("두번째 이벤트 {}", event.getMessage());
    }

    @Async
    @EventListener(AsyncOrderedEchoEvent.class)
    public void threeEvent(AsyncOrderedEchoEvent event) {
        log.info("세번째 이벤트 {}", event.getMessage());
    }
//
//
//    @Async
//    @Order(1)
//    @EventListener(AsyncOrderedEchoEvent.class)
//    public void oneEvent(AsyncOrderedEchoEvent event) {
//        log.info("첫번째 이벤트 {}", event.getMessage());
//    }
//
//    @Async
//    @Order(2)
//    @EventListener(AsyncOrderedEchoEvent.class)
//    public void twoEvent(AsyncOrderedEchoEvent event) throws InterruptedException {
//        log.info("두번째 이벤트 {}", event.getMessage());
//    }
//
//    @Async
//    @Order(3)
//    @EventListener(AsyncOrderedEchoEvent.class)
//    public void threeEvent(AsyncOrderedEchoEvent event) {
//        log.info("세번째 이벤트 {}", event.getMessage());
//    }

}
