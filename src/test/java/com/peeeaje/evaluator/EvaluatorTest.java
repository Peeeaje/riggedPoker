package com.peeeaje.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.peeeaje.card_related.Card;
import com.peeeaje.card_related.Cards;
import org.junit.jupiter.api.Test;

class EvaluatorTest {
    @Test
    void testCheckFlush() {
        Evaluator evaluator = new Evaluator();
        Cards hand1 = new Cards();
        hand1.add(new Card("2", "s"));
        hand1.add(new Card("3", "s"));
        hand1.add(new Card("4", "s"));
        hand1.add(new Card("5", "s"));
        hand1.add(new Card("6", "s"));
        assertEquals(true, evaluator.checkFlush(hand1));

        Cards hand2 = new Cards();
        hand2.add(new Card("2", "s"));
        hand2.add(new Card("3", "s"));
        hand2.add(new Card("4", "s"));
        hand2.add(new Card("5", "s"));
        hand2.add(new Card("6", "d"));
        assertEquals(false, evaluator.checkFlush(hand2));
    }

}