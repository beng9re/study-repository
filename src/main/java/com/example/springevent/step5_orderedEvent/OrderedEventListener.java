package com.example.springevent.step5_orderedEvent;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderedEventListener {

/* 순서 블록 이벤트 시작 */
    @EventListener(OrderedEchoEvent.class)
    public void oneEvent(OrderedEchoEvent event) {
        log.info("첫번째 이벤트 {}", event.getMessage());
    }


    @EventListener(OrderedEchoEvent.class)
    public void twoEvent(OrderedEchoEvent event) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        log.info("두번째 이벤트 {}", event.getMessage());
    }


    @EventListener(OrderedEchoEvent.class)
    public void threeEvent(OrderedEchoEvent event) {
        log.info("세번째 이벤트 {}", event.getMessage());
    }
/* 순서 블록 이벤트 끝 */



/* 순서 미지정 이벤트 시작 */
//    @EventListener(OrderedEchoEvent.class)
//    public void twoEvent(OrderedEchoEvent event) {
//        log.info("두번째 이벤트 {}", event.getMessage());
//    }
//
//    @EventListener(OrderedEchoEvent.class)
//    public void oneEvent(OrderedEchoEvent event) {
//        log.info("첫번째 이벤트 {}", event.getMessage());
//    }
//
//    @EventListener(OrderedEchoEvent.class)
//    public void threeEvent(OrderedEchoEvent event) {
//        log.info("세번째 이벤트 {}", event.getMessage());
//    }
/* 순서 미지정 이벤트 끝 */


/* 순서 지정 이벤트 시작 */
//    @Order(1)
//    @EventListener(OrderedEchoEvent.class)
//    public void twoEvent(OrderedEchoEvent event) {
//        log.info("두번째 이벤트 {}", event.getMessage());
//    }
//
//    @Order(2)
//    @EventListener(OrderedEchoEvent.class)
//    public void oneEvent(OrderedEchoEvent event) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(10);
//        log.info("첫번째 이벤트 {}", event.getMessage());
//    }
//
//    @Order(3)
//    @EventListener(OrderedEchoEvent.class)
//    public void threeEvent(OrderedEchoEvent event) {
//        log.info("세번째 이벤트 {}", event.getMessage());
//    }
/* 순서 지정 이벤트 END */
}
