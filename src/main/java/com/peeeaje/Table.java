package com.peeeaje;

import com.peeeaje.card_related.Cards;
import com.peeeaje.chip_related.Pot;

public class Table {
    private Pot pot = new Pot();
    private Cards board = new Cards();
    private Players players = new Players();

    public Table(Players players) {
        this.players = players;
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

    public void reset() {
        pot.clear();
        board.clear();
        players.killAllHand();
    }
}
