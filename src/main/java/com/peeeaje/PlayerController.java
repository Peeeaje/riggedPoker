package com.peeeaje;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    private PlayerController() {
    }

    public static List<Player> readyPlayers(int numberOfPlayers) {
        final String[] playerName = { "Andy", "Barry", "Cathy", "Darryl", "Earl", "Fred", "Gary", "Hank", "Ike", "Jack",
                "Kenny", "Lenny", "Manny", "Nancy", "Oscar", "Penny", "Quinn", "Randy", "Sandy", "Teddy", "Ulysses",
                "Vernon", "Wendy", "Xander", "Yancy", "Zach" };

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(playerName[i], new Chips(500)));
        }

        return players;
    }
}
