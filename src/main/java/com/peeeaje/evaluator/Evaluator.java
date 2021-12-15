package com.peeeaje.evaluator;

import com.peeeaje.card_related.Cards;

public class Evaluator {
    public boolean checkFlush(Cards hand) {
        int ans = 61440;
        for (int bit : hand.getBitList()) {
            ans = ans & bit;
        }
        return ans != 0;
    }
}
