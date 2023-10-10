package com.example.springevent.step3_anotation.actor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnnotationBasedHelloServiceTest {

    @Autowired
    private AnnotationBasedHelloService annotationBasedHelloService;

    @Test
    void 어노테이션_기반의_이벤트처리() {
        annotationBasedHelloService.call();
    }

}
