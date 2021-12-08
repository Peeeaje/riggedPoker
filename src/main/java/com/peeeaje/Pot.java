package com.peeeaje;

public class Pot {
    // TODO: シングルトンにすべき？
    private Chips potAmount;
    private Chips betAmount;

    public Pot() {
        potAmount = new Chips(0);
        betAmount = new Chips(0);
    }

    public void openPot() {
        potAmount.add(Blind.bigBlind());// TODO: SB/BBを払った時点でAIになった状態を考慮していない
        potAmount.add(Blind.smallBlind());

    }

    public void add(Chips bet) {
        betAmount.add(bet);
    }

    public void sumBetAndPot() {
        // sum the bet and the pot
        potAmount.add(betAmount);
        betAmount.clear();
    }

    public Chips potAmount() {
        return potAmount;
    }

    public Chips betAmount() {
        return betAmount;
    }
}
