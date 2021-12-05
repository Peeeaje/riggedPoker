package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChipsTest {
    @Test
    void testAdd() {
        Chips pot = new Chips(100);
        pot.add(new Chips(50));
        assertEquals(150, pot.amount());
    }
}