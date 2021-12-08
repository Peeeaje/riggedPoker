package com.peeeaje;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Card> cards;

    public Board() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public String getHandValue() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
        }
        return sb.toString();
    }

    public List<Card> cards() {
        return cards;
    }

    public void clear() {
        cards.clear();
    }

    public int numOfCards() {
        return cards.size();
    }

}
