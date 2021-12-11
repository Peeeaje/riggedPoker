package com.peeeaje;

public class Card {
    private String suit;
    private String rank;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        if (!this.rank.matches("[AKQJT98765432]") || !this.suit.matches("[cdhs]")) {
            throw new IllegalArgumentException("Invalid rank or suit");
        }
    }

    public String value() {
        return this.rank + this.suit;
    }

}
