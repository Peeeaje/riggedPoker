package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DealerTest {
    @Test
    void testDealCards() {

        Player player = new Player("TestName", new Chips(100));
        Deck deck = new Deck();
        Dealer.dealCards(player, deck, 2);

        assertEquals(2, player.hand().numOfCards());
    }
}