package com.peeeaje;

import java.util.List;
import java.util.ArrayList;

public class Hand {
    // ハンドの状態を管理するクラス

    private List<Card> cards;

    public Hand() {
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

    public List<Card> getCards() {
        return cards;
    }

    public void clear() {
        cards.clear();
    }

    public int numOfCards() {
        return cards.size();
    }
}
