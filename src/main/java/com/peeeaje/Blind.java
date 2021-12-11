package com.peeeaje;

public class Blind {
    private static Chip bigBlind;
    private static Chip smallBlind;

    private Blind() {
    }

    public static Chip smallBlind() {
        if (smallBlind.amount() == 0) {
            throw new IllegalStateException("Small blind has not been set");
        }
        return smallBlind;
    }

    public static Chip bigBlind() {
        if (bigBlind.amount() == 0) {
            throw new IllegalStateException("Big blind has not been set");
        }
        return bigBlind;
    }

    public static void setBlinds(int sb, int bb) {
        if (sb > bb) {
            throw new IllegalArgumentException("Small blind must be less than big blind");
        }
        smallBlind = new Chip(sb);
        bigBlind = new Chip(bb);
    }

    public static void reset() {
        smallBlind = new Chip(0);
        bigBlind = new Chip(0);
    }

}
