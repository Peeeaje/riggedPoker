package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DealerTest {
    private static final Player List = null;

    @Test
    void testDealCards() {

        Player player = new Player("TestName", new Chip(100));
        Dealer dealer = new Dealer();
        List<Player> players = new ArrayList<>();

        players.add(player);
        dealer.dealHands(players, 2);

        assertEquals(2, player.hand().numOfCards());
    }
}