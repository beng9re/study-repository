package com.example.springevent.step2_asyncEvent.actor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AsyncHelloServiceTest {

    @Autowired
    private AsyncHelloService asyncHelloService;

    @Test
    public void 비동기_이벤트를_수행한다() {
        asyncHelloService.call();
    }

}
