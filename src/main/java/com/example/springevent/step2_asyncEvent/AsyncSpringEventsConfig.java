package com.example.springevent.step2_asyncEvent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;

@Configuration
public class AsyncSpringEventsConfig {

    /**
     * 비동기 이벤트 실행 설정
     * */
//    @Bean(name = "applicationEventMulticaster")
//    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
//        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
//        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
//
//        return eventMulticaster;
//    }





}
