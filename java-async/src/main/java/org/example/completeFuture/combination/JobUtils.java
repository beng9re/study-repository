package org.example.completeFuture.combination;

import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobUtils {
    public static <T> Supplier<T> delayAndCall(long delay, Supplier<T> supplier) {
        return () -> {
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {
            }
            final T jobName = supplier.get();
            log.info("{} 작업 완료", jobName);
            return jobName;
        };
    }

    public static <T> Supplier<T> delayAndCall(Supplier<T> supplier) {
        return () -> {
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException e) {
            }
            final T jobName = supplier.get();
            log.info("{} 작업 완료", jobName);
            return jobName;
        };
    }

}
