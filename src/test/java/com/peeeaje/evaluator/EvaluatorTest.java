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
        assertEquals(31, evaluator.returnFlushValueBit(hand1));

        Cards hand2 = new Cards();
        hand2.add(new Card("A", "s"));
        hand2.add(new Card("K", "s"));
        hand2.add(new Card("Q", "s"));
        hand2.add(new Card("J", "s"));
        hand2.add(new Card("9", "s"));
        assertEquals(true, evaluator.checkFlush(hand2));
        assertEquals(7808, evaluator.returnFlushValueBit(hand2));

        Cards hand3 = new Cards();
        hand3.add(new Card("2", "s"));
        hand3.add(new Card("3", "s"));
        hand3.add(new Card("4", "s"));
        hand3.add(new Card("5", "s"));
        hand3.add(new Card("6", "d"));
        assertEquals(false, evaluator.checkFlush(hand3));
    }

}