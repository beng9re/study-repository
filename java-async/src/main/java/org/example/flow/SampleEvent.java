package org.example.flow;


// 이벤트
public class SampleEvent {
    private String text;

    public SampleEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
