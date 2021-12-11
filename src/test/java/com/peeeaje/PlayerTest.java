package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testIsActive() {
        Player player1 = new Player("player1", new Chip(1000));
        Deck deck = new Deck();

        assertEquals(false, player1.isActive());

        player1.hand().add(deck.pickCard());
        assertEquals(true, player1.isActive());

        player1.hand().clear();
        assertEquals(false, player1.isActive());
    }
}
