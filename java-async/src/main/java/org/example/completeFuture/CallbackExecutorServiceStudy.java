package org.example.completeFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CallbackExecutorServiceStudy {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        CallBackCombineFuture<String> callBackCombineFuture = new CallBackCombineFuture<String>(
                () -> {
                    log.info("1번 작업");
                    return "1";
                },
                (data) -> es.submit(new CallBackCombineFuture<String>(() -> {
                                    log.info("2번 작업");
                                    return data + ", 2";
                                }, System.out::println, System.out::println))

                ,System.out::println
        );

        es.submit(callBackCombineFuture);
    }

}



