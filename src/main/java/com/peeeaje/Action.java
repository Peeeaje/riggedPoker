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
        Player currentPlayer = table.players().currentPlayer();
        int currentPlayerIndex = table.players().currentPlayerIndex();
        Chip payingChip = payingChip(betSize, table);

        if ((isRaise(betSize, table)) || (isBet(betSize, table))) {
            table.actionState().setBetOccurred(true);
            table.players().currentPlayer().setBet(betSize);
            table.players().currentPlayer().setPayingChip(payingChip);
        }

        currentPlayer.stack().subtract(payingChip);
        table.actionState().setPaidChipsOf(currentPlayerIndex, betSize);
        table.pot().add(payingChip);
    }

    public static void fold(Table table) {

        Player currentPlayer = table.players().currentPlayer();
        int currentPlayerIndex = table.players().currentPlayerIndex();

        currentPlayer.killHand();
        table.actionState().setPaidChipsOf(currentPlayerIndex, new Chip(0));
    }

    private static Chip payingChip(Chip betSize, Table table) {
        int currentPlayerIndex = table.players().currentPlayerIndex();
        Chip payingChip = new Chip(betSize.amount());
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
}
