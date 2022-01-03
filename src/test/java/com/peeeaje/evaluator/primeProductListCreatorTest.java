package com.peeeaje.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class primeProductListCreatorTest {
    @Test
    void testQuadsStrength() {
        assertEquals(11, primeProductListCreator.getStrength(41 * 41 * 41 * 41 * 37)); // AAAAK
        assertEquals(166, primeProductListCreator.getStrength(2 * 2 * 2 * 2 * 3)); // 22223
    }

    void testFullHouseStrength() {
        assertEquals(167, primeProductListCreator.getStrength(41 * 41 * 41 * 37 * 37)); // AAAKK
        assertEquals(322, primeProductListCreator.getStrength(2 * 2 * 2 * 3 * 3)); // 22233
    }

    void testThreeOfAKindStrength() {
        assertEquals(1610, primeProductListCreator.getStrength(41 * 41 * 41 * 37 * 31)); // AAAKQ
        assertEquals(2467, primeProductListCreator.getStrength(2 * 2 * 2 * 3 * 5)); // 22234
    }

    void testTwoPairStrength() {
        assertEquals(2468, primeProductListCreator.getStrength(41 * 41 * 37 * 37 * 31)); // AAKKQ
        assertEquals(3325, primeProductListCreator.getStrength(2 * 2 * 3 * 3 * 5)); // 22334
    }

    void testOnePairStrength() {
        assertEquals(3326, primeProductListCreator.getStrength(41 * 41 * 37 * 31 * 29)); // AAKQJ
        assertEquals(6185, primeProductListCreator.getStrength(2 * 2 * 3 * 5 * 7)); // 22345
    }
}
