package com.example.springevent.step5_orderedEvent;

import org.springframework.context.ApplicationEvent;

public class OrderedEchoEvent extends ApplicationEvent {
    private final String message;
    public OrderedEchoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
