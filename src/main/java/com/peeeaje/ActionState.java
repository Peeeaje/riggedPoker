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
    private Deque<List<Object>> actionQueue = new ArrayDeque<>();
    private Deque<List<Object>> finishedActionDeque = new ArrayDeque<>();
    private Map<Integer, Chip> paidChipsMap = new HashMap<>();

    public ActionState(int numOfPlayers) {
        for (int i = 0; i < numOfPlayers; i++) {
            actionQueue.add(new ArrayList<>(Arrays.asList(i, new Chip(0))));
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

    public void logAction(int position, Chip betSize) {
        actionQueue.add(new ArrayList<>(Arrays.asList(position, betSize)));
    }

    public void finishAction() {
        actionQueue.remove();
    }

    public void openAction() {

    }
}
