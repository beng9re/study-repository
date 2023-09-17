package org.example.completeFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CompletableFutureStudy {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        final String data = CompletableFuture.supplyAsync(() -> {
            log.info("1 번 작업");
            return " 1번 작업 완료 ";
        }, es)
        // 이전 쓰레드풀을 이어 받는다
        .thenApply((s)-> {
            log.info("2 번 작업");
            log.info(s);
            return s +  " 2번 작업 완료 ";
        })
        // ForkJoinPool을 사용한다 이어 받는다
        .thenApplyAsync((s) -> {
            log.info("3 번 작업");
            log.info(s);
            return s + " 3번 작업 완료 ";
        }).thenApplyAsync((s) -> {
            log.info("4 번 작업 ");
            log.info(s);
            return s + " 4번 작업 완료 ";
        })
        //에러 핸들링
        .exceptionally((e) -> {
            log.info("error : {}", e.getMessage());
            return "error";
        }).get();

        System.out.println(data);

        es.shutdown();
    }


}
