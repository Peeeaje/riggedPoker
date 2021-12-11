package com.peeeaje;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> playerList;
    private int currentPlayerIndex;

    public Players() {
        this.playerList = new ArrayList<>();
        this.currentPlayerIndex = 0;
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

    public int currentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Player getPlayer(int index) {
        return playerList.get(index);
    }

    public Player currentPlayer() {
        return playerList.get(currentPlayerIndex);
    }

    public int nextPlayerIndexInActivePlayers() {
        return (this.activePlayers().indexOf(this.currentPlayer()) + 1)
                % (this.activePlayers().numOfPlayers());
    }

    public Player nextPlayer() {
        return this.activePlayers().playerList.get(this.nextPlayerIndexInActivePlayers());
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

    public void turnToNextPlayer() {
        this.currentPlayerIndex = this.indexOf(this.nextPlayer());
    }

}
