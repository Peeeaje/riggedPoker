package com.peeeaje;

public class Player {
    // Playerの情報を制御するクラス
    private final String name;
    private Hand hand;
    private Chips chips;
    private boolean isActive;

    public Player(String name, Chips chips) {
        this.hand = new Hand();
        this.name = name;
        this.chips = chips;
        this.isActive = false;
    }

    public Chips chips() {
        return this.chips;
    }

    public Hand hand() {
        return this.hand;
    }

    public String name() {
        return this.name;
    }

    public boolean isActive() {
        // プレイヤーがアクティブかどうかを管理するメソッド
        if (this.hand.numOfCards() == 0) {
            this.isActive = false;
        } else {
            this.isActive = true;
        }
        return this.isActive;
    }

    public void Bet(int amount) {
    }

    public void Fold() {
    }
}
