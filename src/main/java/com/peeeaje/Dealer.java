package com.peeeaje;

import com.peeeaje.card_related.Cards;
import com.peeeaje.card_related.Deck;

public class Dealer {
    private Deck deck;

    public Dealer() {
        deck = new Deck();
        deck.shuffle();
    }

    private void dealCard(Player player) {
        player.getCard(deck.pickCard());

    }

    private void dealBoard(Cards board) {
        board.add(deck.pickCard());
    }

    public void prepareDeck() {
        deck.newShuffledDeck();
    }

    public void dealHands(Players players, int numberOfCards) {
        for (Player player : players.playerList()) {
            for (int i = 0; i < numberOfCards; i++) {
                dealCard(player);
            }
        }
    }

    public void dealFlop(Cards board) {
        for (int i = 0; i < 3; i++) {
            dealBoard(board);
        }
    }

    public void dealTurn(Cards board) {
        dealBoard(board);
    }

    public void dealRiver(Cards board) {
        dealBoard(board);
    }

}
