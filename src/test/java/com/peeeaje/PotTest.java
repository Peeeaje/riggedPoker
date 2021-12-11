package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PotTest {

    @Test
    void testOpenPot() {
        Blind.setBlinds(100, 200);
        Pot pot = new Pot();
        assertEquals(0, pot.potSize().amount());

        pot.openPot();
        assertEquals(300, pot.potSize().amount());
    }
}