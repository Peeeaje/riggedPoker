package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChipTest {
    @Test
    void testAdd() {
        Chip pot = new Chip(100);
        pot.add(new Chip(50));
        assertEquals(150, pot.amount());
    }
}