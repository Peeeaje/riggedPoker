package com.peeeaje;

public class Blind {
    private static Chips bigBlind;
    private static Chips smallBlind;

    private Blind() {
    }

    public static Chips smallBlind() {
        if (smallBlind.amount() == 0) {
            throw new IllegalStateException("Small blind has not been set");
        }
        return smallBlind;
    }

    public static Chips bigBlind() {
        if (bigBlind.amount() == 0) {
            throw new IllegalStateException("Big blind has not been set");
        }
        return bigBlind;
    }

    public static void setBlinds(int sb, int bb) {
        if (sb > bb) {
            throw new IllegalArgumentException("Small blind must be less than big blind");
        }
        smallBlind = new Chips(sb);
        bigBlind = new Chips(bb);
    }

    public static void reset() {
        smallBlind = new Chips(0);
        bigBlind = new Chips(0);
    }

}
