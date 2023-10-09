package com.example.springevent.step1;

import org.springframework.context.ApplicationEvent;

public class EchoEvent extends ApplicationEvent {
    private final String message;
    public EchoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
