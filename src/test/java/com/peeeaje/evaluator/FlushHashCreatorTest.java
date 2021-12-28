package com.peeeaje.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class FlushHashCreatorTest {
    @Test
    void testBitStrengthMap() {
        Map<Integer, Integer> hash = FlushHashCreator.getBitStrengthMap();
        int test1 = hash.get(31); // 65432
        assertEquals(9, test1);

        int test2 = hash.get(7808); // AKQJ9
        assertEquals(323, test2);

        int test3 = hash.get(4111); // A2345
        assertEquals(10, test3);

        int test4 = hash.get(47); // 75432
        assertEquals(1599, test4);
    }
}