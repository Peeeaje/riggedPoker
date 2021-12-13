package com.peeeaje;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static Dealer dealer;
    private static Table table;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            setup();
            while (true) {
                newGame();
                play(scan);

                System.out.println("Do you continue? (y/n)");
                String ans = scan.next();

                if (ans.equals("n")) {
                    break;

                }
            }
        }
    }

    public static void setup() {
        dealer = new Dealer();
        Players players = new Players();
        for (String name : new String[] { "Player1", "Player2" }) {// , "Player3", "Player4",
            // "Player5", "Player6" }) {
            players.addPlayer(new Player(name, new Chip(1000))); // TODO: playersをplayersFactoryとかで作る？
        }
        table = new Table(players);
    }

    public static void newGame() {
        dealer.prepareDeck();
        table.players().killAllHand();
    }

    public static void play(Scanner scan) {
        dealer.prepareDeck();
        dealer.dealHands(table.players(), 2);
        while (!table.actionState().isAllPlayersFinished()) {
            String[] actionList = Action.possibleAction(table);
            System.out.println("Input your action, " + Arrays.toString(actionList));

            String action = scan.next();
            makeAction(action, scan);

        }
    }

    public static void makeAction(String action, Scanner scan) {
        switch (action) {
            case "bet":
                System.out.println("Type your bet size"); {
                int betSize = Integer.parseInt(scan.next());
                Action.bet(new Chip(betSize), table);
            }
                break;

            case "raise":
                System.out.println("Type your raise size"); {
                int betSize = Integer.parseInt(scan.next());
                Action.raise(new Chip(betSize), table);
            }
                break;

            case "call":
                Action.call(table);
                break;

            case "fold":
                Action.fold(table);
                break;

            case "check":
                Action.check(table);
                break;

            default:
                System.out.println("Invalid action");
                break;
        }
    }
}
