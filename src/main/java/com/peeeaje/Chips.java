package com.peeeaje;

public class Chips {
    private int amount;

    public Chips(int amount) {
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    public void extract(int amount) {
        this.amount -= amount;
    }

    public void add(Chips chips) {
        this.amount += chips.amount;
    }

    public void clear() {
        this.amount = 0;
    }
}