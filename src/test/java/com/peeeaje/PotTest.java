package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PotTest {
    @Test
    void testAddAndSum() {
        Pot pot = new Pot();
        pot.add(new Chips(50));
        assertEquals(50, pot.betAmount().amount());
        assertEquals(0, pot.potAmount().amount());

        pot.sumBetAndPot();
        assertEquals(0, pot.betAmount().amount());
        assertEquals(50, pot.potAmount().amount());

    }

    @Test
    void testOpenPot() {
        Blind.setBlinds(100, 200);
        Pot pot = new Pot();
        assertEquals(0, pot.potAmount().amount());

        pot.openPot();
        assertEquals(300, pot.potAmount().amount());
    }
}