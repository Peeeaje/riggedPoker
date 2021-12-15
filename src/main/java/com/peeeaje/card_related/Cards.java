package com.peeeaje.card_related;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private List<Card> cardList;

    public Cards() {
        this.cardList = new ArrayList<>();
    }

    public void add(Card card) {
        cardList.add(card);
    }

    public String getCardsValue() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cardList) {
            sb.append(card.value());
        }
        return sb.toString();
    }

    public void clear() {
        cardList.clear();
    }

    public List<Integer> getBitList() {
        List<Integer> bitList = new ArrayList<>();
        for (Card card : cardList) {
            bitList.add(card.bit());
        }
        return bitList;
    }

    public int numOfCards() {
        return cardList.size();
    }
}
