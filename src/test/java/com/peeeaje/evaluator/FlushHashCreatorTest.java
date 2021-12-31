package com.peeeaje.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class FlushHashCreatorTest {
    @Test
    void testFlushes() {
        Map<Integer, Integer> flushes = FlushHashCreator.getFlushes();
        int test1 = flushes.get(31); // 65432
        assertEquals(9, test1);

        int test2 = flushes.get(7808); // AKQJ9
        assertEquals(323, test2);

        int test3 = flushes.get(4111); // A2345
        assertEquals(10, test3);

        int test4 = flushes.get(47); // 75432
        assertEquals(1599, test4);
    }
}