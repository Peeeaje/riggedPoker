package com.peeeaje.chip_related;

public class Chip {
    private int amount;

    public Chip(int amount) {
        this.amount = amount;
    }

    public int amount() {
        return this.amount;
    }

    @Override
    public boolean equals(Object chip) {
        if (chip instanceof Chip) {
            return this.amount == ((Chip) chip).amount;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.amount;
    }

    public boolean isLargerThan(Chip chip) {
        return this.amount > chip.amount;
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