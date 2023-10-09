package com.example.springevent.step2_asyncEvent.actor;

import com.example.springevent.step2_asyncEvent.AsyncEchoEventPublish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncHelloService {
    private final AsyncEchoEventPublish asyncEchoEventPublish;

    public AsyncHelloService(AsyncEchoEventPublish asyncEchoEventPublish) {
        this.asyncEchoEventPublish = asyncEchoEventPublish;
    }
    void call() {
        log.info("AsyncHelloService.call");
        asyncEchoEventPublish.publish("비동기 hello");
        log.info("AsyncHelloService.end");
    }
}
