package org.example.asyncJava;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ScheduledExecutorServiceStudy {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(2);

        // 1초 후에 1번 작업 실행 하고 1분뒤에 다음 작업을 수행한다.
        ScheduledExecutorService roop = Executors.newScheduledThreadPool(4);
        roop.scheduleAtFixedRate(() -> {
                log.info("scheduleAtFixedRate 반복 작업");
                    try {Thread.sleep(1000);}  catch (InterruptedException e) {}
                }, 0, 1, TimeUnit.SECONDS);

        roop.scheduleWithFixedDelay(() -> {
                    log.info("scheduleWithFixedDelay 반복 작업");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                }, 0, 1, TimeUnit.SECONDS);

        es.shutdown();
    }

}



