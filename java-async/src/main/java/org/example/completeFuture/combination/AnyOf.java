package org.example.completeFuture.combination;

import static org.example.completeFuture.combination.JobUtils.delayAndCall;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AnyOf {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);

        final CompletableFuture<String> _1초_지연된_첫번째_CompletableFuture_작업 =
                CompletableFuture.supplyAsync(delayAndCall(1, () -> {
            log.info("1번 작업");
            return "1번 작업";
        }), es);

        final CompletableFuture<String> _2초_지연된_두번째_CompletableFuture_작업 =
                CompletableFuture.supplyAsync(delayAndCall(2, () -> {
            log.info("2번 작업");
            return "2번 작업";
        }), es);

        final CompletableFuture<String> _3초_지연된_세번째_CompletableFuture_작업 =
                CompletableFuture.supplyAsync(delayAndCall(3, () -> {
            log.info("3번 작업");
            return "3번 작업";
        }), es);

        final String result = (String) CompletableFuture.anyOf(
                _1초_지연된_첫번째_CompletableFuture_작업,
                _2초_지연된_두번째_CompletableFuture_작업,
                _3초_지연된_세번째_CompletableFuture_작업
        ).get();


        System.out.println(result);

        es.shutdown();
    }
}
