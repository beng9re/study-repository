package com.example.springevent.step5_orderedEvent.actor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class OrderedHelloServiceTest {

    @Autowired
    private OrderedHelloService orderedHelloService;

    @Test
    void 순서에_대한_이벤트_처리() {
        orderedHelloService.call();
    }
리
