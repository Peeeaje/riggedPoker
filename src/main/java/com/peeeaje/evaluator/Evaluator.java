package com.peeeaje.evaluator;

import java.util.Map;
import com.peeeaje.card_related.Cards;

public class Evaluator {
    private Map<Integer, Integer> flushes = FlushHashCreator.getFlushes();
    private Map<Integer, Integer> unique5 = Unique5HashCreator.getUnique5();

    public int getStrength(Cards hand) {
        if (hand.numOfCards() != 5) {
            throw new IllegalArgumentException("numOfCards must be 5");
        }

        if (isFlush(hand)) {
            // hand has flush
            int index = Evaluator.unique5Index(hand);
            return flushes.get(index);
        }

        else {
            int index = Evaluator.unique5Index(hand);
            if (unique5.get(index) != null) {
                // all 5 cards are different
                return unique5.get(index);
            } else {
                // all 5 cards are not different
                index = Evaluator.nonUnique5Index(hand);
                return NonUnique5Creator.getStrength(index);
            }
        }
    }

    private boolean isFlush(Cards hand) { // TODO: tempよりもいい命名があれば変えたい
        int temp = 61440;
        for (int bit : hand.getBitList()) {
            temp = temp & bit;
        }
        return temp != 0;
    }

    private static int unique5Index(Cards hand) {
        int temp = 0;
        for (int bit : hand.getBitList()) {
            temp = temp | bit >> 16;
        }
        return temp;
    }

    private static int nonUnique5Index(Cards hand) {
        int temp = 1;
        for (int bit : hand.getBitList()) {
            temp *= 255 & bit;
        }
        return temp;
    }
}
