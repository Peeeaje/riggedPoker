package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DealerTest {
    @Test
    void testDealCards() {

        Player player = new Player("TestName", new Chips(100));
        Dealer dealer = new Dealer();
        dealer.dealCards(player, 2);

        assertEquals(2, player.hand().numOfCards());
    }
}