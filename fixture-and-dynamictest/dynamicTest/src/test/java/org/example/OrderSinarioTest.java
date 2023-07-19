package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;

import org.junit.jupiter.api.TestFactory;

public class OrderSinarioTest {


    @TestFactory
    Stream<DynamicTest> 주문_테스트() {
        return Stream.of(
                dynamicTest("차 생성", () -> {
                    // given
                    Car car = CarFixture.가격이_100000인_테슬라();

                    // when
                    // then
                    assertEquals(car.getName(), "Tesla");
                    assertEquals(car.getPrice(), 100000);
                }),
                dynamicTest("주문 생성", () -> {
                    // given
                    Car car = CarFixture.가격이_100000인_테슬라();
                    int quantity = 2;

                    // when
                    Order order = Order.builder()
                            .car(car)
                            .quantity(quantity)
                            .build();

                    // then
                    assertEquals(car, order.getCar());
                    assertEquals(order.getCar().getName(), "Tesla");
                    assertEquals(quantity, order.getQuantity());
                })
        );
    }
}
