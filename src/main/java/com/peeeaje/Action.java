package com.peeeaje;

import com.peeeaje.chip_related.Chip;
import com.peeeaje.state.TurnState;
import com.peeeaje.state.GameState;

public class Action {
    private Action() {
    }

    public static void bet(Chip betSize, GameState gameState) {
        // スタックの変更、ポットの増加、actionStateの更新
        Player player = gameState.currentPlayer();
        Chip payingChip = gameState.payingChip(betSize);

        subtractFromStack(payingChip, player);
        increasePot(payingChip, gameState);
        gameState.updateGameStateWhenRaiseOrBet(betSize);
    }

    public static void raise(Chip betSize, GameState gameState) {
        bet(betSize, gameState);
    }

    public static void call(GameState gameState) {
        // スタックの変更、ポットの増加、actionStateの更新
        // TODO: Callできるかの判定をしていない
        Player player = gameState.currentPlayer();
        Chip largestBet = gameState.betState().getLargestBet();
        Chip payingChip = gameState.payingChip(largestBet);

        subtractFromStack(payingChip, player);
        increasePot(payingChip, gameState);
        gameState.updateGameStateWhenCall();
    }

    public static void check(GameState gameState) {
        gameState.updateGameStateWhenCheck();
    }

    public static void fold(GameState gameState) {
        // スタックの変更、ポットの変更、actionStateの更新、現在のプレイヤの更新を行なっている
        Table table = gameState.table();
        Player currentPlayer = gameState.currentPlayer();
        gameState.updateGameStateWhenFold();
        currentPlayer.killHand();

        if (gameState.isAllPlayersFinished()) {
            int winnerIndex = gameState.leftPlayerIndex();
            Player winner = table.players().getPlayer(winnerIndex);
            winnerTakesPot(winner, gameState);
        }

    }

    private static void winnerTakesPot(Player winner, GameState gameState) {
        Table table = gameState.table();
        Chip winningChip = table.pot().potSize();
        winner.stack().add(winningChip);
        table.pot().clear();

    }

    private static void subtractFromStack(Chip payingChip, Player player) {
        player.stack().subtract(payingChip);
    }

    private static void increasePot(Chip payingChip, GameState gameState) {
        gameState.table().pot().add(payingChip);
    }

}
