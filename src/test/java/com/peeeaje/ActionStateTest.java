package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ActionStateTest {
    @Test
    void testAction() {
        int numOfPlayers = 3;
        ActionState actionState = new ActionState(numOfPlayers);
        assertFalse(actionState.hasBetOccurred());

    }

    @Test
    void testLargestBetSize() {
        ActionState actionState = new ActionState(3);
        actionState.addPaidChipsOf(0, new Chip(100));
        assertEquals(true, actionState.largestBetSize().equals(new Chip(100)));

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

        assertEquals(true, table.actionState().getPaidChipsOf(0).equals(new Chip(0)));

        table.actionState().addPaidChipsOf(0, new Chip(100));
        assertEquals(true, table.actionState().getPaidChipsOf(0).equals(new Chip(100)));
        assertEquals(true, table.actionState().largestBetSize().equals(new Chip(100)));

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

        table.actionState().makeNonFoldAction();
        assertEquals(1, table.actionState().finishedActionDeque().size());
        assertEquals(2, table.actionState().actionQueue().size());

    }
}
