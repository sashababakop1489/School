package com.knubisoft.tasks.algorithm.fibonacci;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciImplTest {

    private final Fibonacci fibonacci = new FibonacciImpl();

    @Test
    void generateNFibonacciSequence() {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int index = 0; index < 30; index++) {
            assertEquals(fibonacci.generateNFibonacciSequence(index), fib(index, lookup));
        }
    }

  //  @Disabled("TODO fix me")
    @Test
    void generateNFibonacciSequence1000() {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int index = 0; index < 1000; index++) {
            assertEquals(fibonacci.generateNFibonacciSequence(index), fib2(index, lookup));
        }
    }

    // Function to find the nth Fibonacci number
    public static int fib(int n, Map<Integer, Integer> lookup) {
        if (n <= 1) {
            return n;
        }
        lookup.putIfAbsent(n, fib(n - 1, lookup) + fib(n - 2, lookup));
        return lookup.get(n);
    }
    public static int fib2(int n, Map<Integer, Integer> lookup){
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
    int[] arr = new int[n + 1];
    arr[0] = 0;
    arr[1] = 1;
        for (int i = 2; i <= n; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }
        return arr[n];
}
}