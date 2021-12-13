package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ActionTest {
    @Test
    void testCheckAround() {
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Players players = new Players();
        players.addPlayer(player1);
        players.addPlayer(player2);

        Dealer dealer = new Dealer();
        dealer.dealHands(players, 2);
        Table table = new Table(players);

        assertEquals(true, table.pot().potSize().equals(new Chip(0)));
        Action.check(table);

        assertEquals(true, table.pot().potSize().equals(new Chip(0))); // potが正しく変化していないことを確認
        assertEquals(true, table.actionState().largestBetSize().equals(new Chip(0))); // largestBetSizeが0であることを確認
        assertEquals(1, table.actionState().finishedActionDeque().size()); // 終了済みのアクションが3つあることを確認
        assertEquals(1, table.actionState().actionQueue().size()); // アクションが残っていないことを確認
    }

    @Test
    void testBet() {
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Players players = new Players();
        players.addPlayer(player1);
        players.addPlayer(player2);

        Dealer dealer = new Dealer();
        dealer.dealHands(players, 2);
        Table table = new Table(players);

        assertEquals(true, table.pot().potSize().equals(new Chip(0)));
        Action.bet(new Chip(100), table);

        assertEquals(true, table.pot().potSize().equals(new Chip(100))); // potが正しく変化していることを確認
        assertEquals(true, table.actionState().largestBetSize().equals(new Chip(100))); // largestBetSizeが100であることを確認
        assertEquals(1, table.actionState().finishedActionDeque().size()); // 終了済みのアクションが1つあることを確認
        assertEquals(1, table.actionState().actionQueue().size()); // アクションが1つ残っていることを確認
    }

    @Test
    void testBetCall() {
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Players players = new Players();
        players.addPlayer(player1);
        players.addPlayer(player2);

        Dealer dealer = new Dealer();
        dealer.dealHands(players, 2);
        Table table = new Table(players);

        Action.bet(new Chip(100), table);
        assertEquals(true, table.pot().potSize().equals(new Chip(100)));

        Action.call(table);
        assertEquals(true, table.pot().potSize().equals(new Chip(200))); // potが正しく変化していることを確認
        assertEquals(true, table.actionState().largestBetSize().equals(new Chip(100))); // largestBetSizeが100であることを確認
        assertEquals(2, table.actionState().finishedActionDeque().size()); // 終了済みのアクションが2つあることを確認
        assertEquals(0, table.actionState().actionQueue().size()); // アクションが残っていないことを確認

    }

    @Test
    void testBetRaiseCallCall() {
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Player player3 = new Player("player3", new Chip(1000));
        Players players = new Players();
        players.addPlayer(player1);
        players.addPlayer(player2);
        players.addPlayer(player3);

        Dealer dealer = new Dealer();
        dealer.dealHands(players, 2);
        Table table = new Table(players);

        Action.bet(new Chip(100), table);
        assertEquals(true, table.pot().potSize().equals(new Chip(100)));

        Action.raise(new Chip(300), table);
        assertEquals(true, table.pot().potSize().equals(new Chip(400))); // potが正しく変化していることを確認
        assertEquals(true, table.actionState().largestBetSize().equals(new Chip(300))); // largestBetSizeが300であることを確認
        assertEquals(1, table.actionState().finishedActionDeque().size()); // 終了済みのアクションがactionQueueに移動していることを確認
        assertEquals(2, table.actionState().actionQueue().size()); // 2つのアクションが残っていることを確認

        Action.call(table);
        Action.call(table);
        assertEquals(true, table.pot().potSize().equals(new Chip(900))); // potが正しく変化していることを確認
        assertEquals(300, table.actionState().largestBetSize().hashCode());
        // // アクションが閉じた際のlargestBetSizeが0であることを確認
        assertEquals(3, table.actionState().finishedActionDeque().size()); // 終了済みのアクションが3つ
        assertEquals(0, table.actionState().actionQueue().size()); // 0個のアクションが残っていることを確認

    }

    @Test
    void testBetFold() {
        Players players = new Players();
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        players.addPlayer(player1);
        players.addPlayer(player2);

        Dealer dealer = new Dealer();
        dealer.dealHands(players, 2);
        Table table = new Table(players);

        Action.bet(new Chip(100), table);
        Action.fold(table);
        assertEquals(true, player1.stack().equals(new Chip(1000))); // stackが正しく変化していることを確認
        assertEquals(true, table.pot().potSize().equals(new Chip(0))); // potが0になっていることを確認
    }

    @Test
    void testBetRaiseFold() {
        Players players = new Players();
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        players.addPlayer(player1);
        players.addPlayer(player2);

        Dealer dealer = new Dealer();
        dealer.dealHands(players, 2);
        Table table = new Table(players);

        Action.bet(new Chip(100), table);
        Action.raise(new Chip(300), table);
        Action.fold(table);

        assertEquals(true, player1.stack().equals(new Chip(900))); // stackが正しく変化していることを確認
        assertEquals(true, player2.stack().equals(new Chip(1100)));
        assertEquals(true, table.pot().potSize().equals(new Chip(0))); // potが0になっていることを確認

    }
}
