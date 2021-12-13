package com.peeeaje.chip_related;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChipTest {
    @Test
    void testAdd() {
        Chip chip = new Chip(100);
        chip.add(new Chip(50));
        assertEquals(true, chip.equals(new Chip(150)));
    }
}