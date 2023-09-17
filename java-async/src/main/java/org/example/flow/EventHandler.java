package org.example.flow;


@FunctionalInterface
public interface EventHandler<T> {
    void apply(T event);
}
