package org.example.asyncJava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FutureStudy {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        final Future<String> submit = es.submit(() -> {
            Thread.sleep(1000);
            log.info("1 번 작업");
            return "1";
        });

        if (submit.isDone())

        System.out.println("작업 완료 done : " + submit.isDone());

        es.shutdown();
    }
}
