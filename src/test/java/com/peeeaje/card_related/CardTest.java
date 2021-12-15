package com.peeeaje.card_related;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CardTest {
    @Test
    void throwExceptionWhenImproperRank() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Card("S", "s");
        });
        assertEquals("Invalid rank or suit", exception.getMessage());
    }

    @Test
    void throwExceptionWhenImproperSuit() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Card("A", "t");
        });
        assertEquals("Invalid rank or suit", exception.getMessage());
    }

    @Test
    void checkAllCombos() {
        String[] LIST_RANK = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
        String[] LIST_SUIT = new String[] { "c", "d", "h", "s" };

        for (String rank : LIST_RANK) {
            for (String suit : LIST_SUIT) {
                Card card = new Card(rank, suit);
                assertEquals(rank + suit, card.value());
            }
        }
    }

    @Test
    void checkBitValue() {
        Card card1 = new Card("K", "d");
        assertEquals("1000000000000100101100100101", Integer.toBinaryString(card1.bit()));
        Card card2 = new Card("5", "s");
        assertEquals("10000001001100000111", Integer.toBinaryString(card2.bit()));
        Card card3 = new Card("J", "c");
        assertEquals("10000000001000100100011101", Integer.toBinaryString(card3.bit()));
    }

}
