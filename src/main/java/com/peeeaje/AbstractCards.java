package com.peeeaje;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCards {
    private List<Card> cards;

    protected AbstractCards() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public String cardsValue() {
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
