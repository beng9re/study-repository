package com.example.springevent.step4_customTreadPool;

import org.springframework.context.ApplicationEvent;

public class CustomThreadPoolEchoEvent extends ApplicationEvent {
    private final String message;
    public CustomThreadPoolEchoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
