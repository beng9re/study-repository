package org.example;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FutureTest {
    public static int count = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> hello =
                () -> {
                    count++;
                    Thread.sleep(20000L);
                    return "Hello";
                };

        Callable<String> java =
                () -> {
                    count++;
                    Thread.sleep(30000L);
                    return "Java";
                };

        Callable<String> callable =
                () -> {
                    count++;
                    Thread.sleep(10000L);
                    return "Callable";
                };

        String result = executorService.invokeAny(Arrays.asList(hello, java, callable));
        System.out.println("result = " + result);

        executorService.shutdown();
        System.out.println("count = " + count);
    }

}
