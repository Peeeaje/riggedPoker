package com.peeeaje;

public class Dealer {
    private Deck deck;

    public Dealer() {
        deck = new Deck();
        deck.shuffle();
    }

    public void dealCards(Player player, int numCards) {
        for (int i = 0; i < numCards; i++) {
            player.hand().add(deck.pickCard());
        }
    }

}
