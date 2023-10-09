package com.example.springevent.step3_anotation;

import org.springframework.context.ApplicationEvent;

public class AnnotationBasedEchoEvent extends ApplicationEvent {
    private final String message;
    public AnnotationBasedEchoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
