package org.example.asyncJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SingleThreadExecutorStudy {

    public static void main(String[] args)  {
        ExecutorService es = Executors.newSingleThreadExecutor();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            final int index = i;
            log.info("task {} 번", index);
        }

        es.shutdown();
    }

}



