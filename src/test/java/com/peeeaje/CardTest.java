package com.peeeaje;

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
                assertEquals(rank, card.rank());
                assertEquals(suit, card.suit());
                assertEquals(rank + suit, card.value());
            }
        }
    }
}
