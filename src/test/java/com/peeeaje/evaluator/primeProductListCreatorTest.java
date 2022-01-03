package com.peeeaje.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class primeProductListCreatorTest {
    @Test
    void testQuadsStrength() {
        assertEquals(11, NonUnique5Creator.getStrength(41 * 41 * 41 * 41 * 37)); // AAAAK
        assertEquals(166, NonUnique5Creator.getStrength(2 * 2 * 2 * 2 * 3)); // 22223
    }

    void testFullHouseStrength() {
        assertEquals(167, NonUnique5Creator.getStrength(41 * 41 * 41 * 37 * 37)); // AAAKK
        assertEquals(322, NonUnique5Creator.getStrength(2 * 2 * 2 * 3 * 3)); // 22233
    }

    void testThreeOfAKindStrength() {
        assertEquals(1610, NonUnique5Creator.getStrength(41 * 41 * 41 * 37 * 31)); // AAAKQ
        assertEquals(2467, NonUnique5Creator.getStrength(2 * 2 * 2 * 3 * 5)); // 22234
    }

    void testTwoPairStrength() {
        assertEquals(2468, NonUnique5Creator.getStrength(41 * 41 * 37 * 37 * 31)); // AAKKQ
        assertEquals(3325, NonUnique5Creator.getStrength(2 * 2 * 3 * 3 * 5)); // 22334
    }

    void testOnePairStrength() {
        assertEquals(3326, NonUnique5Creator.getStrength(41 * 41 * 37 * 31 * 29)); // AAKQJ
        assertEquals(6185, NonUnique5Creator.getStrength(2 * 2 * 3 * 5 * 7)); // 22345
    }
}
