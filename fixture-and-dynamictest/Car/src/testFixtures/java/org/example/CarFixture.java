package org.example;

import org.example.Car;

public class CarFixture {
    public static Car getCar() {
        return Car.builder()
                .name("Tesla")
                .price(100000)
                .build();
    }

    public static Car 가격이_100000인_테슬라() {
        return Car.builder()
                .name("Tesla")
                .price(100000)
                .build();
    }
}
