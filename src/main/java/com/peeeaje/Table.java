package com.peeeaje;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private Pot pot = new Pot();
    private Chips bet = new Chips(0);
    private Board board = new Board();
    private List<Player> players = new ArrayList<>();
    private Dealer dealer = new Dealer();
    private int dealerIndex = 0;
    private int currentPlayerIndex = 0;

    public Chips pot() {
        return pot;
    }

    public Chips bet() {
        return bet;
    }

    public Board board() {
        return board;
    }

    public List<Player> players() {
        return players;
    }

    public void addBetToPot() {
        // sum the bet and the pot
        pot.add(bet);
    }
}
