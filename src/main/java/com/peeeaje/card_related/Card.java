package com.peeeaje.card_related;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

public class Card {
    // +--------+--------+--------+--------+
    // |xxxbbbbb|bbbbbbbb|cdhsrrrr|xxpppppp|
    // +--------+--------+--------+--------+

    // p = prime number of rank (deuce=2,trey=3,four=5,...,ace=41)
    // r = rank of card (deuce=0,trey=1,four=2,five=3,...,ace=12)
    // cdhs = suit of card (bit turned on based on suit of card)
    // b = bit turned on depending on rank of card

    private String suit; // TODO: suit and rank variable can be altered by methods
    private String rank;
    private int bit = 0;
    private static final Map<String, Integer> primeNumberHash = new HashMap<>();
    private static final List<Integer> primeNumList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41);
    private static final List<Integer> intNumList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    private static final List<String> suitList = Arrays.asList("s", "h", "d", "c");
    private static final List<String> stringNumList = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9",
            "T", "J", "Q", "K", "A");
    static {
        for (int i = 0; i < stringNumList.size(); i++) {
            primeNumberHash.put(stringNumList.get(i), primeNumList.get(i));
        }
    }

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        if (!this.rank.matches("[AKQJT98765432]") || !this.suit.matches("[cdhs]")) {
            throw new IllegalArgumentException("Invalid rank or suit");
        }
        setBitValue(rank, suit);
    }

    public String value() {
        return this.rank + this.suit;
    }

    public int bit() {
        return this.bit;
    }

    private int primeNumber(String rank) {
        return primeNumberHash.get(rank);
    }

    private void setPrimeNumber(String rank) {
        this.bit = this.bit | primeNumber(rank);
    }

    private void setRankOfCard(String rank) {
        this.bit = this.bit | intNumList.get(stringRankToIndex(rank)) << 8;
    }

    private void setSuitOfCard(String suit) {
        this.bit = this.bit | 1 << 12 + suitList.indexOf(suit);
    }

    private void setBitRankOfCard(String rank) {
        this.bit = this.bit | 1 << 16 + stringNumList.indexOf(rank);
    }

    private void setBitValue(String rank, String suit) {
        setPrimeNumber(rank);
        setRankOfCard(rank);
        setBitRankOfCard(rank);
        setSuitOfCard(suit);
    }

    private int stringRankToIndex(String rank) {
        return stringNumList.indexOf(rank);
    }

}
