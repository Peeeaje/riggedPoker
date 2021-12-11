package com.peeeaje;

public class Chip {
    private int amount;

    public Chip(int amount) {
        this.amount = amount;
    }

    public int amount() {
        return this.amount;
    }

    public void add(Chip chip) {
        this.amount += chip.amount;
    }

    public void subtract(Chip chip) {
        if (this.amount - chip.amount < 0) {
            throw new IllegalArgumentException("Not enough chips");
        }

        this.amount -= chip.amount;
    }
}