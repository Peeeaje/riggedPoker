package com.peeeaje;

public class Player {
    // Playerの情報を制御するクラス
    private final String name;
    private Cards hand;
    private Chip stack;

    public Player(String name, Chip chips) {
        this.hand = new Cards();
        this.name = name;
        this.stack = chips;
    }

    public Chip stack() {
        return this.stack;
    }

    public Cards hand() {

        return this.hand;
    }

    public String name() {
        return this.name;
    }

    public boolean isActive() {
        // プレイヤーがアクティブかどうかを管理するメソッド
        return (this.hand.numOfCards() != 0);
    }

    public void killHand() {
        // プレイヤーの手札を破棄するメソッド
        this.hand = new Cards();
    }
}
