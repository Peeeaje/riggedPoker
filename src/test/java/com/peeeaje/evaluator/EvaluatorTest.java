package com.peeeaje.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.peeeaje.card_related.Card;
import com.peeeaje.card_related.Cards;
import org.junit.jupiter.api.Test;

class EvaluatorTest {
    @Test
    void testStraightFlush() {
        Evaluator evaluator = new Evaluator();
        Cards RoyalFlush = new Cards();
        RoyalFlush.add(new Card("A", "s"));
        RoyalFlush.add(new Card("K", "s"));
        RoyalFlush.add(new Card("Q", "s"));
        RoyalFlush.add(new Card("J", "s"));
        RoyalFlush.add(new Card("T", "s"));
        assertEquals(1, evaluator.getStrength(RoyalFlush));

        Cards weakestStraightFlush = new Cards();
        weakestStraightFlush.add(new Card("2", "s"));
        weakestStraightFlush.add(new Card("3", "s"));
        weakestStraightFlush.add(new Card("4", "s"));
        weakestStraightFlush.add(new Card("5", "s"));
        weakestStraightFlush.add(new Card("A", "s"));
        assertEquals(10, evaluator.getStrength(weakestStraightFlush));
    }

    @Test
    void testQuads() {
        Evaluator evaluator = new Evaluator();
        Cards strongestQuads = new Cards();
        strongestQuads.add(new Card("A", "d"));
        strongestQuads.add(new Card("A", "s"));
        strongestQuads.add(new Card("A", "h"));
        strongestQuads.add(new Card("A", "c"));
        strongestQuads.add(new Card("K", "s"));
        assertEquals(11, evaluator.getStrength(strongestQuads));

        Cards weakestQuads = new Cards();
        weakestQuads.add(new Card("2", "d"));
        weakestQuads.add(new Card("2", "s"));
        weakestQuads.add(new Card("2", "h"));
        weakestQuads.add(new Card("2", "c"));
        weakestQuads.add(new Card("3", "s"));
        assertEquals(166, evaluator.getStrength(weakestQuads));
    }

    @Test
    void testFullHouse() {
        Evaluator evaluator = new Evaluator();
        Cards strongestFullHouse = new Cards();
        strongestFullHouse.add(new Card("A", "d"));
        strongestFullHouse.add(new Card("A", "s"));
        strongestFullHouse.add(new Card("A", "h"));
        strongestFullHouse.add(new Card("K", "c"));
        strongestFullHouse.add(new Card("K", "s"));
        assertEquals(167, evaluator.getStrength(strongestFullHouse));

        Cards weakestFullHouse = new Cards();
        weakestFullHouse.add(new Card("2", "d"));
        weakestFullHouse.add(new Card("2", "s"));
        weakestFullHouse.add(new Card("2", "h"));
        weakestFullHouse.add(new Card("3", "c"));
        weakestFullHouse.add(new Card("3", "s"));
        assertEquals(322, evaluator.getStrength(weakestFullHouse));
    }

    @Test
    void testFlush() {
        Evaluator evaluator = new Evaluator();
        Cards strongestFlush = new Cards();
        strongestFlush.add(new Card("9", "s"));
        strongestFlush.add(new Card("J", "s"));
        strongestFlush.add(new Card("Q", "s"));
        strongestFlush.add(new Card("K", "s"));
        strongestFlush.add(new Card("A", "s"));
        assertEquals(323, evaluator.getStrength(strongestFlush));

        Cards weakestFlush = new Cards();
        weakestFlush.add(new Card("2", "s"));
        weakestFlush.add(new Card("3", "s"));
        weakestFlush.add(new Card("4", "s"));
        weakestFlush.add(new Card("5", "s"));
        weakestFlush.add(new Card("7", "s"));
        assertEquals(1599, evaluator.getStrength(weakestFlush));
    }

    @Test
    void testStraight() {
        Evaluator evaluator = new Evaluator();
        Cards strongestStraight = new Cards();
        strongestStraight.add(new Card("T", "d"));
        strongestStraight.add(new Card("J", "d"));
        strongestStraight.add(new Card("Q", "s"));
        strongestStraight.add(new Card("K", "s"));
        strongestStraight.add(new Card("A", "s"));
        assertEquals(1600, evaluator.getStrength(strongestStraight));

        Cards weakestStraight = new Cards();
        weakestStraight.add(new Card("2", "d"));
        weakestStraight.add(new Card("3", "d"));
        weakestStraight.add(new Card("4", "s"));
        weakestStraight.add(new Card("5", "s"));
        weakestStraight.add(new Card("A", "s"));
        assertEquals(1609, evaluator.getStrength(weakestStraight));
    }

    @Test
    void testThreeOfAKind() {
        Evaluator evaluator = new Evaluator();
        Cards strongestThree = new Cards();
        strongestThree.add(new Card("A", "d"));
        strongestThree.add(new Card("A", "s"));
        strongestThree.add(new Card("A", "h"));
        strongestThree.add(new Card("K", "c"));
        strongestThree.add(new Card("Q", "s"));
        assertEquals(1610, evaluator.getStrength(strongestThree));

        Cards weakestThree = new Cards();
        weakestThree.add(new Card("2", "d"));
        weakestThree.add(new Card("2", "s"));
        weakestThree.add(new Card("2", "h"));
        weakestThree.add(new Card("3", "c"));
        weakestThree.add(new Card("4", "s"));
        assertEquals(2467, evaluator.getStrength(weakestThree));
    }

    @Test
    void testTwoPair() {
        Evaluator evaluator = new Evaluator();
        Cards weakestTwoPair = new Cards();
        Cards strongestTwoPair = new Cards();
        strongestTwoPair.add(new Card("A", "d"));
        strongestTwoPair.add(new Card("A", "s"));
        strongestTwoPair.add(new Card("K", "h"));
        strongestTwoPair.add(new Card("K", "c"));
        strongestTwoPair.add(new Card("Q", "s"));
        assertEquals(2468, evaluator.getStrength(strongestTwoPair));

        weakestTwoPair.add(new Card("2", "d"));
        weakestTwoPair.add(new Card("2", "s"));
        weakestTwoPair.add(new Card("3", "h"));
        weakestTwoPair.add(new Card("3", "c"));
        weakestTwoPair.add(new Card("4", "s"));
        assertEquals(3325, evaluator.getStrength(weakestTwoPair));
    }

    @Test
    void testOnePair() {
        Evaluator evaluator = new Evaluator();
        Cards strongestOnePair = new Cards();
        strongestOnePair.add(new Card("A", "d"));
        strongestOnePair.add(new Card("A", "s"));
        strongestOnePair.add(new Card("K", "h"));
        strongestOnePair.add(new Card("Q", "c"));
        strongestOnePair.add(new Card("J", "s"));
        assertEquals(3326, evaluator.getStrength(strongestOnePair));

        Cards weakestOnePair = new Cards();
        weakestOnePair.add(new Card("2", "d"));
        weakestOnePair.add(new Card("2", "s"));
        weakestOnePair.add(new Card("3", "h"));
        weakestOnePair.add(new Card("4", "c"));
        weakestOnePair.add(new Card("5", "s"));
        assertEquals(6185, evaluator.getStrength(weakestOnePair));
    }

    @Test
    void testHighCard() {
        Evaluator evaluator = new Evaluator();
        Cards strongestHighCard = new Cards();
        strongestHighCard.add(new Card("9", "d"));
        strongestHighCard.add(new Card("J", "d"));
        strongestHighCard.add(new Card("Q", "s"));
        strongestHighCard.add(new Card("K", "s"));
        strongestHighCard.add(new Card("A", "s"));
        assertEquals(6186, evaluator.getStrength(strongestHighCard));

        Cards weakestHighCard = new Cards();
        weakestHighCard.add(new Card("2", "d"));
        weakestHighCard.add(new Card("3", "d"));
        weakestHighCard.add(new Card("4", "s"));
        weakestHighCard.add(new Card("5", "s"));
        weakestHighCard.add(new Card("7", "s"));
        assertEquals(7462, evaluator.getStrength(weakestHighCard));
    }

    @Test
    void test7Cards() {
        Evaluator evaluator = new Evaluator();
        Cards board = new Cards();
        board.add(new Card("A", "d"));
        board.add(new Card("A", "s"));
        board.add(new Card("K", "h"));
        board.add(new Card("Q", "c"));
        board.add(new Card("J", "s"));

        Cards hand = new Cards();
        hand.add(new Card("A", "c"));
        hand.add(new Card("K", "d"));
        assertEquals(167, evaluator.getStrength(board, hand));
    }
}