package com.peeeaje;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private Pot pot = new Pot();
    private Cards board = new Cards();
    private Players players = new Players();
    private Deck deck = new Deck();
    private ActionState actionState;
    private int buttonIndex = 0;

    public Table(Players players) {
        this.players = players;
        this.actionState = new ActionState(players.numOfPlayers());
    }

    public Pot pot() {
        return pot;
    }

    public Cards board() {
        return board;
    }

    public Players players() {
        return players;
    }

    public ActionState actionState() {
        return actionState;
    }

    public Deck deck() {
        return deck;
    }
}
