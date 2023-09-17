package org.example.flow;

import java.util.Scanner;
import java.util.concurrent.Flow;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlowStudy {

    public static void main(String[] args) {

        SamplePublisher publisher = new SamplePublisher();
        publisher.subscribe(new SampleSubscriber<>((event) -> {
            log.info("event를 처리한다. : {}" ,event.getText());
        }));

        IntStream.range(0 , 2000)
                .forEach(i -> {
                    publisher.publish(new SampleEvent(i  + "번쨰 이벤트"));
        });

        //메시지_콘솔에서_주기(publisher);
    }

    private static void 메시지_콘솔에서_주기(SamplePublisher publisher) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("메시지 전송 : ");
            final String message = scanner.next();

            publisher.publish(new SampleEvent(message));

        }
    }
}
