package com.peeeaje.evaluator;

import java.util.Map;
import com.peeeaje.card_related.Cards;

public class Evaluator {
    private Map<Integer, Integer> flushes = FlushHashCreator.getFlushes();
    private Map<Integer, Integer> unique5 = Unique5HashCreator.getUnique5();

    public boolean checkFlush(Cards hand) {
        int ans = 61440;
        for (int bit : hand.getBitList()) {
            ans = ans & bit;
        }
        return ans != 0;
    }

    public int returnFlushValueBit(Cards hand) {
        int ans = 0;
        for (int bit : hand.getBitList()) {
            ans = ans | bit >> 16;
        }
        return ans;
    }
}
