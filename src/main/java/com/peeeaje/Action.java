package com.peeeaje;

public class Action {
    private Action() {
    }

    public String[] possibleAction(Table table) {
        // 出せる選択肢を返す
        if (table.actionState().hasBetOccurred()) {
            return new String[] { "Raise", "Call", "Fold" };
        }
        return new String[] { "Bet", "Check", "Fold" };
    }

    public static void bet(Chip betSize, Table table) {
        // スタックの変更、支払った金額の記録、ポットの増加、actionStateの更新、現在のプレイヤの更新を行なっている
        Chip payingChip = payingChip(betSize, table);

        if ((isRaise(betSize, table)) || (isBet(betSize, table))) {
            table.actionState().openAction();
        }

        increasePot(payingChip, table);
        subtractFromStack(payingChip, table);
        updateActionState(betSize, table);
        turnToNextPlayer(table);
    }

    public static void raise(Chip betSize, Table table) {
        bet(betSize, table);
    }

    public static void call(Table table) {
        // TODO: Callできるかの判定をしていない
        Chip callingChip = table.actionState().largestBetSize();
        bet(callingChip, table);
    }

    public static void check(Table table) {
        bet(new Chip(0), table);
    }

    public static void fold(Table table) {
        Player currentPlayer = table.players().currentPlayer();
        int currentPlayerIndex = table.players().currentPlayerIndex();

        currentPlayer.killHand();
        table.actionState().setPaidChipsOf(currentPlayerIndex, new Chip(0));
    }

    public static Chip payingChip(Chip betSize, Table table) {
        int currentPlayerIndex = table.players().currentPlayerIndex();
        Chip payingChip = betSize;
        Chip paidChip = table.actionState().getPaidChipsOf(currentPlayerIndex);

        payingChip.subtract(paidChip);
        return payingChip;

    }

    private static boolean isBet(Chip betSize, Table table) {
        Chip largestBetSize = table.actionState().largestBetSize();
        return ((largestBetSize.amount() == 0) && (betSize.amount() > 0));
    }

    private static boolean isRaise(Chip betSize, Table table) {
        Chip largestBetSize = table.actionState().largestBetSize();
        return (betSize.amount() > largestBetSize.amount());
    }

    private static boolean isCall(Chip betSize, Table table) {
        return ((!isRaise(betSize, table)) || (!isBet(betSize, table)));
    }

    public static void subtractFromStack(Chip payingChip, Table table) {
        Player currentPlayer = table.players().currentPlayer();
        currentPlayer.stack().subtract(payingChip);
    }

    public static void increasePot(Chip payingChip, Table table) {
        table.pot().add(payingChip);
    }

    public static void updateActionState(Chip betSize, Table table) {
        int currentPlayerIndex = table.players().currentPlayerIndex();

        table.actionState().setPaidChipsOf(currentPlayerIndex, betSize);
        table.actionState().makeAction();
    }

    private static void turnToNextPlayer(Table table) {
        table.players().turnToNextPlayer();
    }
}
