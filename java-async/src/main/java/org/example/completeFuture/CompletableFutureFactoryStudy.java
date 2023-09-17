package org.example.completeFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CompletableFutureFactoryStudy {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        CompletableFuture.supplyAsync(() -> {
            log.info("1 번 작업");
            return " 1번 작업 완료 ";
        // 이전 작업을 이어 받고 다음 작업의 파라미터을 주고 싶을때
        }, es).thenApply((v) -> {
            log.info("이전 작업 {}", v);
            log.info("2 번 작업");
            return " 2번 작업 완료 ";
        // 이전 작업을 이어 받고 다음 작업을 실행 하고 싶을때
        }).thenAccept((s) -> {
            log.info("이전 작업 {}", s);
            log.info("3 번 작업");
        // 이전 작업을 이어 받고 반환 타입이 필요 없을때
        }).thenRun(() -> {
            log.info("실행 작업");
        })
        // 다른 쓰레드에서 작업을 수행한다.
        .thenRunAsync(() -> {
            log.info("다른 쓰레드 작업 실행 작업");
        // 다른 쓰레드에서 작업을 수행하는데 다음 작업의 파라미터를 주고 싶을때
        }).thenApplyAsync((s) -> {
            log.info("다른 쓰레드 작업 1 번 작업");
            return "1 번 작업 완료";
        // 다른 쓰레드에서 작업을 파라미터를 이어 받고 실행 하고 싶을떄
        }).thenAcceptAsync((s) -> {
            log.info("다른 쓰레드 작업 2 번 작업 {}", s);
            log.info("다른 쓰레드 작업 2 번 작업");
        // 다른 쓰레드에서 이어 받고 반환 타입이 필요 없을때
        }).thenRunAsync(() -> {
            log.info("다른 쓰레드 작업 3 번 작업");
        })
        .get();

        es.shutdown();
    }


}
