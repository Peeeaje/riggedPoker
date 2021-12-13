package com.peeeaje.card_related;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;

    public Deck() {
        newShuffledDeck();
    }

    public List<Card> cards() {
        return this.cards;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public void shuffle(Random seed) {
        Collections.shuffle(this.cards, seed);
    }

    public Card pickCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck");
        }
        return this.cards.remove(0);
    }

    public void newShuffledDeck() {
        this.cards = new ArrayList<>();
        for (String rank : new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" }) {
            for (String suit : new String[] { "c", "d", "h", "s" }) {
                this.cards.add(new Card(rank, suit));
            }
        }
        this.shuffle();
    }
}