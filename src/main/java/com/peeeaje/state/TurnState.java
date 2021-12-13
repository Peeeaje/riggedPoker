package com.peeeaje.state;

import java.util.ArrayDeque;
import java.util.Deque;

public class TurnState {
    // これからのアクションのプレイヤーインデックスと、終了したアクションのプレイヤーインデックスを管理する
    private Deque<Integer> toDoDeque = new ArrayDeque<>();
    private Deque<Integer> doneDeque = new ArrayDeque<>();
    private int numOfPlayers;
    private int buttonIndex;

    public TurnState(int numOfPlayers, int buttonIndex) {
        this.numOfPlayers = numOfPlayers;
        this.buttonIndex = buttonIndex;
        for (int i = buttonIndex; i < (numOfPlayers + buttonIndex); i++) {
            toDoDeque.add(i % numOfPlayers);
        }
    }

    public int getCurrentPlayerIndex() {
        return toDoDeque.getFirst();
    }

    public void passToDoToDone() {
        // TODO: より良い命名
        // toDoDequeからplayerをpop、doneDequeにadd
        doneDeque.add(toDoDeque.pop());
    }

    public void omitFromToDo() {
        // toDoDequeからplayerをpop、doneDequeにaddはしない
        toDoDeque.pop();
    }

    public void uniteDeque() {
        // doneDequeをtoDoDequeに追加
        for (int i = 0; i < doneDeque.size(); i++) {
            toDoDeque.add(doneDeque.pop());
        }
    }

    protected int getFirstOfDoneDeque() {
        return doneDeque.getFirst();
    }

    public void moveButton() {
        this.buttonIndex = (buttonIndex + 1) % numOfPlayers;
    }

    public void reset() {
        toDoDeque.clear();
        doneDeque.clear();

        for (int i = 0; i < numOfPlayers; i++) {
            toDoDeque.add(i);
        }
    }

    public int lenOfToDoDeque() {
        return toDoDeque.size();
    }

    public int lenOfDoneDeque() {
        return doneDeque.size();
    }

}
