package com.peeeaje;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ActionState {
    private Deque<Integer> actionQueue = new ArrayDeque<>();
    private Deque<Integer> finishedActionDeque = new ArrayDeque<>();
    private Map<Integer, Chip> paidChipsMap = new HashMap<>();

    public ActionState(int numOfPlayers) {
        for (int i = 0; i < numOfPlayers; i++) {
            actionQueue.add(i);
            setPaidChipsOf(i, new Chip(0));
        }
    }

    public boolean hasBetOccurred() {
        int sum = 0;
        for (Chip value : paidChipsMap.values()) {
            sum += value.amount();
        }
        return (sum != 0);
    }

    public Deque<Integer> finishedActionDeque() {
        return finishedActionDeque;
    }

    public Deque<Integer> actionQueue() {
        return actionQueue;
    }

    public void setPaidChipsOf(int position, Chip betSize) {
        this.paidChipsMap.put(position, betSize);
    }

    public Chip getPaidChipsOf(int position) {
        return this.paidChipsMap.get(position);
    }

    public Chip largestBetSize() {
        int largestBetSize = 0;
        for (Chip value : paidChipsMap.values()) {
            if (value.amount() > largestBetSize) {
                largestBetSize = value.amount();
            }
        }
        return new Chip(largestBetSize);
    }

    public void makeAction() {
        // actionQueueからplayerをpop、finishedActionDequeにadd
        finishedActionDeque.add(actionQueue.pop());
    }

    public void openAction() {
        // finishedActionDequeをactionQueueに追加
        for (int i = 0; i < this.finishedActionDeque.size(); i++) {
            this.actionQueue.add(this.finishedActionDeque.remove());
        }
    }

    public boolean isAllPlayersFinished() {
        return this.actionQueue.isEmpty();
    }
}
