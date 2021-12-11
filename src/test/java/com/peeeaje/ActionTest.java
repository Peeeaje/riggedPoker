package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ActionTest {
    @Test
    void testAction() {
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Player player3 = new Player("player3", new Chip(1000));

        Players players = new Players();
        players.addPlayer(player1);
        players.addPlayer(player2);
        players.addPlayer(player3);

        Table table = new Table(players);
        assertEquals(0, players.currentPlayerIndex()); // 0から開始
        assertEquals(0, table.pot().potSize().amount()); // pot = 0

        Action.bet(new Chip(100), table);
        assertEquals(100, table.pot().potSize().amount()); // pot = 100
        // ActionState actionState = new ActionState(2);
        // player1.bet(new Chip(100), actionState);
    }

}
