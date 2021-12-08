package com.peeeaje;

public class Action {
    private Action() {
    }

    public static void bet(int betSize, Pot pot) {
        pot.add(new Chips(betSize));
    }
}
