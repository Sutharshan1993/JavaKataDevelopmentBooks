package org.java.kata.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.java.kata.Service.BookstoreService;
import org.java.kata.Service.BookstoreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaKataApplicationTests {

    private final BookstoreService bookstoreService = new BookstoreServiceImpl();

    @Test
    public void testSingleBookNoDiscount() {
        double price = bookstoreService.calculateTotalPrice(Map.of("Clean Code", 1));
        assertEquals(50.0, price, 0.01);
    }

    @Test
    public void testTwoDifferentBooksWith5PercentDiscount() {
        double price = bookstoreService.calculateTotalPrice(Map.of(
                "Clean Code", 1,
                "The Clean Coder", 1
        ));
        assertEquals(95.0, price, 0.01);
    }

    @Test
    public void testMultipleSetsWithDiscounts() {
        double price = bookstoreService.calculateTotalPrice(Map.of(
                "Clean Code", 2,
                "The Clean Coder", 2,
                "Clean Architecture", 2,
                "Test Driven Development", 1,
                "Working Effectively With Legacy Code", 1
        ));
        assertEquals(320.0, price, 0.01);
    }

    @Test
    public void testEmptyBasket() {
        double price = bookstoreService.calculateTotalPrice(Map.of());
        assertEquals(0.0, price, 0.01);
    }}
