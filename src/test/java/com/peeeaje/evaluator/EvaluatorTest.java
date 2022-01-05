package com.peeeaje.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.peeeaje.card_related.Cards;
import org.junit.jupiter.api.Test;

class EvaluatorTest {
    @Test
    void testStraightFlush() {
        Evaluator evaluator = new Evaluator();
        Cards RoyalFlush = new Cards("AsKsQsJsTs");
        assertEquals(1, evaluator.getStrength(RoyalFlush));

        Cards weakestStraightFlush = new Cards("As2s3s4s5s");
        assertEquals(10, evaluator.getStrength(weakestStraightFlush));
    }

    @Test
    void testQuads() {
        Evaluator evaluator = new Evaluator();
        Cards strongestQuads = new Cards("AdAsAhAcKs");
        assertEquals(11, evaluator.getStrength(strongestQuads));

        Cards weakestQuads = new Cards("2d2s2h2c3s");
        assertEquals(166, evaluator.getStrength(weakestQuads));
    }

    @Test
    void testFullHouse() {
        Evaluator evaluator = new Evaluator();
        Cards strongestFullHouse = new Cards("AdAsAhKcKs");
        assertEquals(167, evaluator.getStrength(strongestFullHouse));

        Cards weakestFullHouse = new Cards("2d2s2h3c3s");
        assertEquals(322, evaluator.getStrength(weakestFullHouse));
    }

    @Test
    void testFlush() {
        Evaluator evaluator = new Evaluator();
        Cards strongestFlush = new Cards("AsKsQsJs9s");
        assertEquals(323, evaluator.getStrength(strongestFlush));

        Cards weakestFlush = new Cards("7s5s4s3s2s");
        assertEquals(1599, evaluator.getStrength(weakestFlush));
    }

    @Test
    void testStraight() {
        Evaluator evaluator = new Evaluator();
        Cards strongestStraight = new Cards("AsKsQsJdTd");
        assertEquals(1600, evaluator.getStrength(strongestStraight));

        Cards weakestStraight = new Cards("As2s3s4d5d");
        assertEquals(1609, evaluator.getStrength(weakestStraight));
    }

    @Test
    void testThreeOfAKind() {
        Evaluator evaluator = new Evaluator();
        Cards strongestThree = new Cards("AdAsAhKcQs");
        assertEquals(1610, evaluator.getStrength(strongestThree));

        Cards weakestThree = new Cards("2s2d2h3s4d");
        assertEquals(2467, evaluator.getStrength(weakestThree));
    }

    @Test
    void testTwoPair() {
        Evaluator evaluator = new Evaluator();
        Cards strongestTwoPair = new Cards("AdAsKhKcQs");
        assertEquals(2468, evaluator.getStrength(strongestTwoPair));

        Cards weakestTwoPair = new Cards("2d2s3d3s4d");
        assertEquals(3325, evaluator.getStrength(weakestTwoPair));
    }

    @Test
    void testOnePair() {
        Evaluator evaluator = new Evaluator();
        Cards strongestOnePair = new Cards("AdAsKhQcJs");
        assertEquals(3326, evaluator.getStrength(strongestOnePair));

        Cards weakestOnePair = new Cards("2d2s3h4c5s");
        assertEquals(6185, evaluator.getStrength(weakestOnePair));
    }

    @Test
    void testHighCard() {
        Evaluator evaluator = new Evaluator();
        Cards strongestHighCard = new Cards("AsKsQdJd9d");
        assertEquals(6186, evaluator.getStrength(strongestHighCard));

        Cards weakestHighCard = new Cards("7s5h4c3d2d");
        assertEquals(7462, evaluator.getStrength(weakestHighCard));
    }

    @Test
    void test7Cards() {
        Evaluator evaluator = new Evaluator();
        Cards board = new Cards("AdAsKhQcJs");

        Cards hand = new Cards("AcKd");
        assertEquals(167, evaluator.getStrength(board, hand));
    }
}