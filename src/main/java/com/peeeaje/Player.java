package com.peeeaje;

import com.peeeaje.card_related.Card;
import com.peeeaje.card_related.Cards;
import com.peeeaje.chip_related.Chip;

public class Player {
    // Playerの情報を制御するクラス
    private final String name;
    private Cards hand;
    private Chip stack;
    private int index;
    private static int indexSetter = 0;

    public Player(String name, Chip chips) {
        this.hand = new Cards();
        this.name = name;
        this.stack = chips;
        this.index = indexSetter++;
    }

    public Chip stack() {
        return this.stack;
    }

    public int index() {
        return this.index;
    }

    public void swapSeat(Player otherPlayer) {
        int tmp = this.index;
        this.index = otherPlayer.index;
        otherPlayer.index = tmp;
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

    public void getCard(Card card) {
        this.hand.add(card);
    }
}
