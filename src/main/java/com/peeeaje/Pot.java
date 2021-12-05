package com.peeeaje;

public class Pot extends Chips {
    // TODO: シングルトンにすべき？
    public Pot() {
        super(0);
    }

    public void openPot() {
        this.add(Blind.bigBlind());// TODO: SB/BBを払った時点でAIになった状態を考慮していない
        this.add(Blind.smallBlind());

    }
}
