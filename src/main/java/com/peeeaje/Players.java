package com.peeeaje;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> playerList;

    public Players() {
        this.playerList = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    public int numOfPlayers() {
        return playerList.size();
    }

    public int indexOf(Player player) {
        return playerList.indexOf(player);
    }

    public Player getPlayer(int index) {
        return playerList.get(index);
    }

    public Players activePlayers() {
        Players activePlayers = new Players();
        for (Player player : playerList) {
            if (player.isActive()) {
                activePlayers.addPlayer(player);
            }
        }

        return activePlayers;
    }

    public List<Player> playerList() {
        return playerList;
    }

    public void killAllHand() {
        for (Player player : playerList) {
            player.killHand();
        }
    }

}
