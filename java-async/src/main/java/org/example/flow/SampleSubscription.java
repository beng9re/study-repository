package org.example.flow;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;


//주요 작업 처리자 (구독)
public class SampleSubscription<SampleEvent> implements Subscription {
    private static final ExecutorService executor = ForkJoinPool.commonPool();
    private final CopyOnWriteArrayList<SampleEvent> que = new CopyOnWriteArrayList<>();
    private Subscriber<? super SampleEvent> subscriber;

    @Override
    public void request(long n) {
        final Future<?> submit = executor.submit(() -> {
            if (que.isEmpty()) {
                return;
            }
            subscriber.onNext(que.remove(0));
        });

        try {
            submit.get();
        } catch (InterruptedException | ExecutionException e) {
            cancel();
            throw new RuntimeException(e);
        }
    }
    public void onSubscriber(Subscriber<? super SampleEvent> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void cancel() {
        //구독 취소 처리

    }

    public void add(SampleEvent item) {
        que.add(item);
    }

}
