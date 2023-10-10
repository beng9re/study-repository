package com.example.springevent.step4_customTreadPool.actor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomThreadPoolHelloServiceTest {

    @Autowired
    CustomThreadPoolHelloService customThreadPoolHelloService;

    @Test
    void 커스텀_스레드풀_이벤트_처리() {
        customThreadPoolHelloService.call();
    }
}
