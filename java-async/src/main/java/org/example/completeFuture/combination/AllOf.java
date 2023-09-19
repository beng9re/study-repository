package org.example.completeFuture.combination;

import static org.example.completeFuture.combination.JobUtils.delayAndCall;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AllOf {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        final CompletableFuture<String> 첫번째_CompletableFuture_작업 = CompletableFuture.supplyAsync(delayAndCall(1, () -> {
            log.info("1번 작업");
            return "1번 작업";
        }), es);

        final CompletableFuture<String> 두번째_CompletableFuture_작업 = CompletableFuture.supplyAsync(delayAndCall(1, () -> {
            log.info("2번 작업");
            return "2번 작업";
        }), es);

        final CompletableFuture<String> 세번째_CompletableFuture_작업 = CompletableFuture.supplyAsync(delayAndCall(1, () -> {
            log.info("3번 작업");
            return "3번 작업";
        }), es);

        CompletableFuture.allOf(
                첫번째_CompletableFuture_작업.thenRun(() -> {
                    log.info("1-1번작업");
                }),
                두번째_CompletableFuture_작업,
                세번째_CompletableFuture_작업
        );

        es.shutdown();

        //voidCompletableFuture.get();


    }



}
