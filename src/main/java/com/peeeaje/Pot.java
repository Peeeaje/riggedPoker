package com.peeeaje;

public class Pot {
    // TODO: シングルトンにすべき？
    private Chip potSize;

    public Pot() {
        potSize = new Chip(0);
    }

    public void openPot() {
        Chip startingChip = new Chip(0);
        startingChip.add(Blind.bigBlind());
        startingChip.add(Blind.smallBlind());

        this.potSize = startingChip;
        // TODO: SB/BBを払った時点でAIになった状態を考慮していない
    }

    public void add(Chip bet) {
        this.potSize.add(bet);
    }

    public Chip potSize() {
        return this.potSize;
    }

    public void clear() {
        this.potSize = new Chip(0);
    }
}
