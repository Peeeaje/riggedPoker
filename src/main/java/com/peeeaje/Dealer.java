package com.peeeaje;

public class Dealer {
    private Dealer() {
    }

    public static void dealCards(Player player, Deck deck, int numCards) {
        for (int i = 0; i < numCards; i++) {
            player.hand().add(deck.pickCard());
        }
    }

}
