package com.peeeaje.state;

import java.util.HashMap;
import java.util.Map;
import com.peeeaje.chip_related.Chip;

public class BetState {
    private Map<Integer, Chip> paidChipsMap = new HashMap<>();

    public BetState(int numOfPlayers) {
        for (int i = 0; i < numOfPlayers; i++) {
            paidChipsMap.put(i, new Chip(0));
        }
    }

    public boolean hasBetOccurred() {
        Chip sum = new Chip(0);
        for (Chip value : paidChipsMap.values()) {
            sum.add(value);
        }
        return (!sum.equals(new Chip(0)));
    }

    public void addPaidChipsOf(int position, Chip betSize) {
        Chip chip = paidChipsMap.get(position);
        chip.add(betSize);
        paidChipsMap.put(position, chip);
    }

    public Chip getPaidChipsOf(int position) {
        return this.paidChipsMap.get(position);
    }

    public Chip getLargestBet() {
        Chip largestBetSize = new Chip(0);
        for (Chip value : paidChipsMap.values()) {
            if (value.isLargerThan(largestBetSize)) {
                largestBetSize = value;
            }
        }
        return largestBetSize;
    }

    public void reset() {
        for (int i = 0; i < this.paidChipsMap.size(); i++) {
            paidChipsMap.put(i, new Chip(0));
        }
    }

}
