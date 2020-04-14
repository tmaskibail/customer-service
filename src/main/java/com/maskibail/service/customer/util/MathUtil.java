package com.maskibail.service.customer.util;

public class MathUtil {

    public static Integer fibonacciRecursive(Integer n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
