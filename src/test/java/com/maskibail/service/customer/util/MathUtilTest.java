package com.maskibail.service.customer.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathUtilTest {

    @Test
    void shouldReturn1For1() {
        assertEquals(1, MathUtil.fibonacciRecursive(1));
    }

    @Test
    public void shouldReturn3For3() {
        assertEquals(3, MathUtil.fibonacciRecursive(3));
    }

    @Test
    public void shouldReturn5For4() {
        assertEquals(5, MathUtil.fibonacciRecursive(4));
    }
}