package com.example.springevent.step6_asyncOrderedEvent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class SingleThreadExecutor {

    @Bean
    public Executor single() {
        return Executors.newSingleThreadExecutor();
    }

}
