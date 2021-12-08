package com.peeeaje;

import java.util.List;

public class Dealer {
    private Deck deck;

    public Dealer() {
        deck = new Deck();
        deck.shuffle();
    }

    private void dealCard(Player player) {
        player.hand().add(deck.pickCard());

    }

    private void dealBoard(Board board) {
        board.add(deck.pickCard());

    }

    public void dealHands(List<Player> players, int numberOfCards) {
        for (Player player : players) {
            for (int i = 0; i < numberOfCards; i++) {
                dealCard(player);
            }
        }
    }

    public void dealFlop(Board board) {
        for (int i = 0; i < 3; i++) {
            dealBoard(board);
        }
    }

    public void dealTurn(Board board) {
        dealBoard(board);
    }

    public void dealRiver(Board board) {
        dealBoard(board);
    }

}
