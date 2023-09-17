package org.example.flow;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;


// 발행자
public class SamplePublisher implements Publisher<SampleEvent> {
    private final SampleSubscription<SampleEvent> subscription;

    public SamplePublisher() {
        this.subscription = new SampleSubscription<>();
    }

    //구독자 등록
    @Override
    public void subscribe(Subscriber<? super SampleEvent> subscriber) {
        subscription.onSubscriber(subscriber);
        subscriber.onSubscribe(subscription);
    }

    public void publish(SampleEvent item) {
        subscription.add(item);
        subscription.request(1);
    }
}
