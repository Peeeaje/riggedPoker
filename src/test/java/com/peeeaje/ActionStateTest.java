package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ActionStateTest {
    @Test
    void testAction() {
        int numOfPlayers = 3;
        ActionState actionState = new ActionState(numOfPlayers);
        assertFalse(actionState.hasBetOccurred());

    }

    @Test
    void testPaidChipsMap() {
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Player player3 = new Player("player3", new Chip(1000));

        Players players = new Players();
        players.addPlayer(player1);
        players.addPlayer(player2);
        players.addPlayer(player3);

        Table table = new Table(players);

        assertEquals(new Chip(0).amount(),
                table.actionState().getPaidChipsOf(0).amount());

        table.actionState().setPaidChipsOf(0, new Chip(100));
        assertEquals(new Chip(100).amount(),
                table.actionState().getPaidChipsOf(0).amount());

        assertEquals(new Chip(100).amount(),
                table.actionState().largestBetSize().amount());
    }

    @Test
    void testQueue() {
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Player player3 = new Player("player3", new Chip(1000));

        Players players = new Players();
        players.addPlayer(player1);
        players.addPlayer(player2);
        players.addPlayer(player3);

        Table table = new Table(players);

        assertEquals(0, table.actionState().finishedActionDeque().size());
        assertEquals(3, table.actionState().actionQueue().size());

        table.actionState().makeAction();
        assertEquals(1, table.actionState().finishedActionDeque().size());
        assertEquals(2, table.actionState().actionQueue().size());

    }
}
