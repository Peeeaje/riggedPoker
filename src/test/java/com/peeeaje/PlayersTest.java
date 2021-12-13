package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.peeeaje.chip_related.Chip;
import com.peeeaje.card_related.Deck;
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
    void testActivePlayers() {
        Players players = new Players();
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Player player3 = new Player("player3", new Chip(1000));
        Deck deck = new Deck();

        players.addPlayer(player1);
        players.addPlayer(player2);
        players.addPlayer(player3);

        // only player 1 and 3 are active
        player1.hand().add(deck.pickCard());
        player3.hand().add(deck.pickCard());

        assertEquals(2, players.activePlayers().numOfPlayers());
    }
}
