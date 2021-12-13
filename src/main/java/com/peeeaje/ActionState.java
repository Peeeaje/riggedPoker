package com.peeeaje;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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
        Chip sum = new Chip(0);
        for (Chip value : paidChipsMap.values()) {
            sum.add(value);
        }
        return (!sum.equals(new Chip(0)));
    }

    public Deque<Integer> finishedActionDeque() {
        return finishedActionDeque;
    }

    public Deque<Integer> actionQueue() {
        return actionQueue;
    }

    private void setPaidChipsOf(int position, Chip betSize) {
        this.paidChipsMap.put(position, betSize);
    }

    public void addPaidChipsOf(int position, Chip betSize) {
        Chip chip = paidChipsMap.get(position);
        chip.add(betSize);
        paidChipsMap.put(position, chip);
    }

    public Chip getPaidChipsOf(int position) {
        return this.paidChipsMap.get(position);
    }

    public Chip largestBetSize() {
        Chip largestBetSize = new Chip(0);
        for (Chip value : paidChipsMap.values()) {
            if (value.isLargerThan(largestBetSize)) {
                largestBetSize = value;
            }
        }
        return largestBetSize;
    }

    public void makeNonFoldAction() {
        // actionQueueからplayerをpop、finishedActionDequeにadd
        finishedActionDeque.add(actionQueue.pop());
    }

    public void makeFoldAction() {
        // actionQueueからplayerをpop、finishedActionDequeにaddはしない
        actionQueue.pop();
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
