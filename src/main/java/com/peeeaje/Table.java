package com.peeeaje;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private Pot pot = new Pot();
    private Chips bet = new Chips(0);
    private Board board = new Board();

    public Chips pot() {
        return pot;
    }

    public Chips bet() {
        return bet;
    }

    public Board board() {
        return board;
    }

    public void addBetToPot() {
        // sum the bet and the pot
        pot.add(bet);
    }
}
