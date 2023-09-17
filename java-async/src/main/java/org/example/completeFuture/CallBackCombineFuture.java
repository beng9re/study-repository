package org.example.completeFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;


public class CallBackCombineFuture<T> extends FutureTask<T> {

    private Consumer<T> successCallback;
    private Consumer<Throwable> errorCallback;

    public CallBackCombineFuture(Callable<T> callable, Consumer<T> successCallback, Consumer errorCallback) {
        super(callable);
        this.successCallback = successCallback;
        this.errorCallback = errorCallback;
    }

    @Override
    protected void done() {
        super.done();
        try {
            successCallback.accept(get());
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("CallBackCombineFuture.done");
            errorCallback.accept(e.getCause());
        }
    }
}
