package com.peeeaje.card_related;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DeckTest {
    @Test
    void checkLength() {
        Deck deck = new Deck();
        assertEquals(52, deck.cards().size());
    }

    @Test
    void testPickCard() {
        Deck deck = new Deck();
        deck.pickCard();
        assertEquals(51, deck.cards().size());
    }

    @Test
    void throwExceptionWhenNoCardsLeft() {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            deck.pickCard();
        }

        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            deck.pickCard();
        });
        assertEquals("No cards left in the deck", exception.getMessage());
    }

}
