package com.peeeaje;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private Pot pot = new Pot();
    private Chips bet = new Chips(0);
    private Board board = new Board();
    private List<Player> players = new ArrayList<>();
    private Dealer dealer = new Dealer();
    private int buttonIndex = 0;
    private int currentPlayerIndex = 0;

    public Pot pot() {
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

}
