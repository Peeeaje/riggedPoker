package com.peeeaje.state;

import com.peeeaje.Player;
import com.peeeaje.Table;
import com.peeeaje.chip_related.Chip;

public class GameState {
    private BetState betState;
    private TurnState turnState;
    private Table table;

    public Player currentPlayer() {
        int currentPlayerIndex = turnState.getCurrentPlayerIndex();
        return table.players().getPlayer(currentPlayerIndex);
    }

    public GameState(Table table) {
        this.table = table;
        this.betState = new BetState(table.players().numOfPlayers());
        this.turnState = new TurnState(table.players().numOfPlayers(), 0);
    }

    public Table table() {
        return table;
    }

    public BetState betState() {
        return betState;
    }

    public TurnState turnState() {
        return turnState;
    }

    public boolean isAllPlayersFinished() {
        return turnState.lenOfToDoDeque() == 0;
    }

    public void updateGameStateWhenRaiseOrBet(Chip betSize) {
        int currentPlayerIndex = turnState.getCurrentPlayerIndex(); // TODO: actionstateの更新をもう少しスマートにできないか
        betState.addPaidChipsOf(currentPlayerIndex, betSize);
        turnState.uniteDeque();
        turnState.makeNextToDoDone(); // TODO: unite -> passの順番でないといけないが、turnState側でそこについて管理できないだろうか
    }

    public void updateGameStateWhenCall() {
        int currentPlayerIndex = turnState.getCurrentPlayerIndex();
        Chip largestBet = betState.getLargestBet();
        Chip payingChip = payingChip(largestBet);
        betState.addPaidChipsOf(currentPlayerIndex, payingChip);
        turnState.makeNextToDoDone();
    }

    public void updateGameStateWhenCheck() {
        turnState.makeNextToDoDone();
    }

    public void updateGameStateWhenFold() {
        turnState.omitFromToDo();
    }

    public Chip payingChip(Chip betSize) {
        // calculate extra chips that the player need to pay
        int currentPlayerIndex = turnState.getCurrentPlayerIndex();
        Chip payingChip = betSize;
        Chip paidChip = betState.getPaidChipsOf(currentPlayerIndex);

        payingChip.subtract(paidChip);
        return payingChip;
    }

    public void reset() {
        betState.reset();
        turnState.reset();
        table.reset();
    }

    public String[] possibleAction() {
        if (betState.hasBetOccurred()) {
            return new String[] { "raise", "call", "fold" };
        }
        return new String[] { "bet", "check" };
    }

    public int leftPlayerIndex() {
        // index of player who is left when the others folded
        return turnState.getFirstOfDoneDeque();
    }

    // public openPot() {}

    // public void nextTurn
}
