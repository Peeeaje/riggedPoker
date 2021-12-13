package com.peeeaje.chip_related;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PotTest {

    @Test
    void testOpenPot() {
        Blind.setBlinds(100, 200);
        Pot pot = new Pot();
        assertEquals(true, pot.potSize().equals(new Chip(0)));

        pot.openPot();
        assertEquals(true, pot.potSize().equals(new Chip(300)));
    }
}