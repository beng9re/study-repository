package com.example.springevent.step6_asyncOrderedEvent.actor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AsyncOrderedHelloServiceTest {
    @Autowired
    private AsyncOrderedHelloService asyncOrderedHelloService;

    @Test
    void 비동기_순서_이벤트를_테스트한다() {
        asyncOrderedHelloService.call();
    }

}
