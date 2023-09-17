package org.example.flow;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import lombok.extern.slf4j.Slf4j;

// 구독자
@Slf4j
public class SampleSubscriber<SampleEvent> implements Subscriber<SampleEvent> {
    private Subscription subscription;

    private EventHandler<SampleEvent> handler;

    public SampleSubscriber(EventHandler<SampleEvent> handler) {
        this.handler = handler;
    }


    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(SampleEvent item) {
        handler.apply(item);
        subscription.request(1);
    }
    @Override
    public void onError(Throwable throwable) {
        //에러 처리 내용
    }
    @Override
    public void onComplete() {
        //완료
    }
}
