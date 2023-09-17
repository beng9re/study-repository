package org.example.asyncJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CachingExecutorServiceStudy {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            final int index = i;
            es.submit(() -> log.info("{} 번 작업", index));
        }

        es.shutdown();
    }

}



