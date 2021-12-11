package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

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

        assertEquals(0, table.pot().potSize().amount());
        Action.check(table);

        assertEquals(0, table.pot().potSize().amount()); // potが正しく変化していないことを確認
        assertEquals(0, table.actionState().largestBetSize().amount()); // largestBetSizeが0であることを確認
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

        assertEquals(0, table.pot().potSize().amount());
        Action.bet(new Chip(100), table);

        assertEquals(100, table.pot().potSize().amount()); // potが正しく変化していることを確認
        assertEquals(100, table.actionState().largestBetSize().amount()); // largestBetSizeが0であることを確認
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
        assertEquals(100, table.pot().potSize().amount());

        Action.call(table);
        assertEquals(200, table.pot().potSize().amount()); // potが正しく変化していることを確認
        assertEquals(100, table.actionState().largestBetSize().amount()); // largestBetSizeが0であることを確認
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
        assertEquals(100, table.pot().potSize().amount());

        Action.raise(new Chip(300), table);
        assertEquals(400, table.pot().potSize().amount()); // potが正しく変化していることを確認
        assertEquals(300, table.actionState().largestBetSize().amount()); // largestBetSizeが0であることを確認
        assertEquals(1, table.actionState().finishedActionDeque().size()); // 終了済みのアクションがactionQueueに移動していることを確認
        assertEquals(2, table.actionState().actionQueue().size()); // 2つのアクションが残っていることを確認

        Action.call(table);
        Action.call(table);
        assertEquals(900, table.pot().potSize().amount()); // potが正しく変化していることを確認
        assertEquals(300, table.actionState().largestBetSize().amount()); // largestBetSizeが0であることを確認
        assertEquals(3, table.actionState().finishedActionDeque().size()); // 終了済みのアクションが3つ
        assertEquals(0, table.actionState().actionQueue().size()); // 0個のアクションが残っていることを確認

    }

}
