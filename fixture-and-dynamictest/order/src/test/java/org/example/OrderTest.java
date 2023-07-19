package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("가격이_100000인_테슬라 주문 생성")
    void createOrder() {
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
    }



}