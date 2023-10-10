package com.example.springevent.step6_asyncOrderedEvent;

import org.springframework.context.ApplicationEvent;

public class AsyncOrderedEchoEvent extends ApplicationEvent {
    private final String message;
    public AsyncOrderedEchoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
