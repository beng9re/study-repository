package org.example.completeFuture.combination;

import static org.example.completeFuture.combination.JobUtils.delayAndCall;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ThenCompose {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        final CompletableFuture<String> _1초_지연된_첫번째_CompletableFuture_작업 =
                CompletableFuture.supplyAsync(delayAndCall(1, () -> {
            log.info("1번 작업");
            return "1번 작업";
        }), es);


        String 최종_데이터 = _1초_지연된_첫번째_CompletableFuture_작업
                .thenCompose((data) -> CompletableFuture.supplyAsync(delayAndCall(3, () -> {
                    log.info("thenCompose 작업");
                    return data;
                }), es)).get();



        System.out.println(최종_데이터);

        es.shutdown();
    }
}
