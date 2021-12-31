package com.peeeaje.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class Unique5HashCreatorTest {
    @Test
    void testUnique5() {
        Map<Integer, Integer> unique5 = Unique5HashCreator.getUnique5();
        int test1 = unique5.get(3968); // KQJT9 without flush
        assertEquals(1601, test1);

        int test2 = unique5.get(47); // 76542 without flush
        assertEquals(7462, test2);

        int test3 = unique5.get(55); // 76432 without flush
        assertEquals(7461, test3);
    }
}
