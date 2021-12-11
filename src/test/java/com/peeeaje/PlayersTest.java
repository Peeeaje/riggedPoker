package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    void testPositionAndNumOfPlayers() {
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));

        Players players = new Players();
        players.addPlayer(player1);
        players.addPlayer(player2);

        assertEquals(2, players.numOfPlayers());
        assertEquals(0, players.indexOf(player1));
        assertEquals(1, players.indexOf(player2));
    }

    @Test
    void testTurnToNextPlayer() {
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Player player3 = new Player("player3", new Chip(1000));
        Deck deck = new Deck();

        // only player 1 and 3 are active
        player1.hand().add(deck.pickCard());
        player3.hand().add(deck.pickCard());

        Players players = new Players();
        players.addPlayer(player1);
        players.addPlayer(player2);
        players.addPlayer(player3);

        assertEquals(2, players.activePlayers().numOfPlayers());
        assertNotEquals(players.currentPlayer(), players.nextPlayer());
        assertEquals("player3", players.nextPlayer().name());

        assertEquals(2, players.indexOf(players.nextPlayer()));
        assertEquals(0, players.currentPlayerIndex());
        players.turnToNextPlayer();
        assertEquals(2, players.currentPlayerIndex());
        players.turnToNextPlayer();
        assertEquals(0, players.currentPlayerIndex());
    }
}
