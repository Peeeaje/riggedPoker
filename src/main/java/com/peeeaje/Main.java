package com.peeeaje;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = PlayerController.readyPlayers(6);
        Deck deck = new Deck();

        deck.shuffle();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Dealer.dealCards(player, deck, 2);
            System.out
                    .println(player.name() + ": " + player.chips().amount() + " " + player.hand());

        }
    }
}
