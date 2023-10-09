package com.example.springevent.step2_asyncEvent;

import org.springframework.context.ApplicationEvent;

public class AsyncEchoEvent extends ApplicationEvent {
    private final String message;
    public AsyncEchoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
