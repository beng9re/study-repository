package org.example.completeFuture;

import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WhatIsParallelStreamThreadFool {

    public static void main(String[] args) {
        IntStream.range(0 , 1000).parallel().forEach(i -> {
            log.info("i: {}", i);
        });
    }
}
