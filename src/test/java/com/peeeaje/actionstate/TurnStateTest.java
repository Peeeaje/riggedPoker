package com.peeeaje.actionstate;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.peeeaje.state.TurnState;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TurnStateTest {
    @Test
    void testOmitFromToDo() {
        TurnState turnState = new TurnState(3, 0);

        assertFalse(turnState.isAllPlayersFinished());
        for (int i = 0; i < 3; i++) {
            turnState.omitFromToDo();
        }
        assertTrue(turnState.isAllPlayersFinished());
    }

    @Test
    void testPassToDoToDone() {
        TurnState turnState = new TurnState(3, 0);

        assertEquals(0, turnState.getCurrentPlayerIndex());
        turnState.passToDoToDone();
        assertEquals(1, turnState.getCurrentPlayerIndex());
    }

    @Test
    void testUniteDeque() {
        TurnState turnState = new TurnState(3, 0);

        for (int i = 0; i < 2; i++) {
            turnState.passToDoToDone();
        }
        assertEquals(2, turnState.getCurrentPlayerIndex());
        turnState.uniteDeque();
        turnState.passToDoToDone();
        assertEquals(0, turnState.getCurrentPlayerIndex());
    }
}
