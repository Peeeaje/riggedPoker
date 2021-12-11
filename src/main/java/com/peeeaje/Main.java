package com.peeeaje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static List<Player> players;
    private static Dealer dealer;
    private static ActionState actionState;
    private static Table table;

    public static void main(String[] args) {
        Map map = new HashMap();
        for (int i = 0; i < 10; i++) {
            map.put(i, "AAA");
        }
        System.out.println(map.get(11));
        // setup();
        // while (true) {
        // play();
        // System.out.println("Do you continue? (y/n)");
        // Scanner scan = new Scanner(System.in);
        // String ans = scan.next();

        // if (ans.equals("n")) {
        // break;
        // }
        // }
        // }

        // public static void setup() {
        // dealer = new Dealer();
        // table = new Table();
        // actionState = new ActionState(table.players().size());

        // }

        // public static void play() {
        // }
    }
}