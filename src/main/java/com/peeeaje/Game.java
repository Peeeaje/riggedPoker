package com.peeeaje;

import java.util.Arrays;
import java.util.Scanner;
import com.peeeaje.chip_related.Chip;
import com.peeeaje.evaluator.Evaluator;
import com.peeeaje.state.GameState;

public class Game {
    private static Dealer dealer;
    private static Scanner scan = new Scanner(System.in);
    private static GameState gameState;

    public static void main(String[] args) {
        setup();
        Table table = gameState.table();
        Evaluator evaluator = new Evaluator();
        while (true) {
            prepareGame();

            dealer.dealHands(table.players(), 2);
            play(scan);

            dealer.dealFlop(table.board());
            play(scan);

            dealer.dealTurn(table.board());
            play(scan);

            dealer.dealRiver(table.board());
            play(scan);

            System.out.println("Do you continue? (y/n)");
            String ans = scan.next();

            if (ans.equals("n")) {
                break;

            }
        }
    }

    public static void setup() {
        Players players = new Players();
        for (String name : new String[] { "Player1", "Player2" }) {// , "Player3","Player4", "Player5", "Player6" }) {

            players.addPlayer(new Player(name, new Chip(1000))); // TODO:playersをplayersFactoryとかで作る？
        }

        dealer = new Dealer();
        gameState = new GameState(new Table(players));
    }

    public static void prepareGame() {
        dealer.prepareDeck();
        gameState.reset();
    }

    public static void play(Scanner scan) {
        Table table = gameState.table();
        while (!gameState.isAllPlayersFinished()) {
            Player player = gameState.currentPlayer();
            String[] actionList = gameState.possibleAction();
            displayPlayerInfo(player);
            displayTableInfo(table);

            System.out.println("You can make, " + Arrays.toString(actionList));

            String action = scan.next();
            makeAction(action, scan);
        }
        gameState.turnState().reset();
        gameState.betState().reset();
    }

    public static void makeAction(String action, Scanner scan) {
        switch (action) {
            case "bet":
                System.out.println("Type your bet size"); {
                int betSize = Integer.parseInt(scan.next());
                Action.bet(new Chip(betSize), gameState);
            }
                break;

            case "raise":
                System.out.println("Type your raise size"); {
                int betSize = Integer.parseInt(scan.next());
                Action.raise(new Chip(betSize), gameState);
            }
                break;

            case "call":
                Action.call(gameState);
                break;

            case "fold":
                Action.fold(gameState);
                break;

            case "check":
                Action.check(gameState);
                break;

            default:
                System.out.println("Invalid action");
                break;
        }
    }

    public static void displayPlayerInfo(Player player) {
        System.out.println(player.name() + ": " + player.stack().amount());
        System.out.println("Your hand is " + player.hand().getCardsValue());
    }

    public static void displayTableInfo(Table table) {
        System.out.println("Pot is " + table.pot().amount());
        System.out.println("The board is " + table.board().getCardsValue());
    }
}
