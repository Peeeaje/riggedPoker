package com.peeeaje.card_related;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CardsTest {
    @Test
    void testCards() {
        Cards cards = new Cards("AsKsQsJsTs");
        assertEquals(5, cards.numOfCards());
        assertEquals("AsKsQsJsTs", cards.getCardsValue());
    }

}
