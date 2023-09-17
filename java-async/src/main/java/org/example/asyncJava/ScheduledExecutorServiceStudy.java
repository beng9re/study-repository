package org.example.asyncJava;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ScheduledExecutorServiceStudy {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(2);


        // 1초 후에 1번 작업 실행 하고 1분뒤에 다음 작업을 수행한다.
        es.schedule(() -> log.info("1번 작업"), 1, TimeUnit.MINUTES);
        es.schedule(() -> log.info("2번 작업"), 1, TimeUnit.MINUTES);
        es.schedule(() -> log.info("3번 작업"), 1, TimeUnit.SECONDS);
        es.schedule(() -> log.info("4번 작업"), 1, TimeUnit.SECONDS);


        ScheduledExecutorService roop = Executors.newScheduledThreadPool(100);
        roop.scheduleAtFixedRate(() -> log.info("반복 작업"), 0, 1, TimeUnit.SECONDS);

        es.shutdown();
        //roop.shutdown();
    }

}



