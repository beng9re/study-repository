package com.example.springevent.step1.actor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloServiceTest {
    @Autowired
    private HelloService helloService;

    @Test
    void 이벤트를_발행하고_수신한다() {
        helloService.call("이벤트 ~");
    }

}
