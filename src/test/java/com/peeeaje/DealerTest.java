package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.peeeaje.chip_related.Chip;

class DealerTest {

    @Test
    void testDealCards() {

        Player player = new Player("TestName", new Chip(100));
        Dealer dealer = new Dealer();
        Players players = new Players();

        players.addPlayer(player);

        dealer.dealHands(players, 2);
        assertEquals(2, player.hand().numOfCards());
    }
}