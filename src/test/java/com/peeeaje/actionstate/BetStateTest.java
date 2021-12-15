package com.peeeaje.actionstate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.peeeaje.chip_related.Chip;
import com.peeeaje.state.BetState;

import org.junit.jupiter.api.Test;

class BetStateTest {
    @Test
    void testIfBetOccurred() {
        int numOfPlayers = 4;
        BetState betState = new BetState(numOfPlayers);
        assertFalse(betState.hasBetOccurred());
        betState.addPaidChipsOf(0, new Chip(100));
        assertTrue(betState.hasBetOccurred());
    }

    @Test
    void testLargestBetSize() {
        BetState betState = new BetState(3);
        betState.addPaidChipsOf(0, new Chip(100));
        betState.addPaidChipsOf(1, new Chip(200));
        assertEquals(true, betState.getLargestBet().equals(new Chip(200)));
    }
}
