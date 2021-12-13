package com.peeeaje;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.peeeaje.chip_related.Chip;
import com.peeeaje.state.GameState;

import org.junit.jupiter.api.Test;

class ActionTest {
    @Test
    void testCheckAround() {
        Players players = new Players();
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        players.addPlayer(player1);
        players.addPlayer(player2);

        Dealer dealer = new Dealer();
        Table table = new Table(players);
        GameState gameState = new GameState(table);

        dealer.dealHands(players, 2);

        assertEquals(true, table.pot().potSize().equals(new Chip(0)));
        Action.check(gameState);

        assertEquals(true, table.pot().potSize().equals(new Chip(0))); // potが正しく変化していないことを確認
        assertEquals(true, gameState.betState().getLargestBet().equals(new Chip(0))); // largestBetSizeが0であることを確認
        assertEquals(1, gameState.turnState().lenOfDoneDeque()); // 終了済みのアクションが3つあることを確認
        assertEquals(1, gameState.turnState().lenOfToDoDeque()); // アクションが残っていないことを確認
    }

    @Test
    void testBet() {
        Players players = new Players();
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        players.addPlayer(player1);
        players.addPlayer(player2);

        Dealer dealer = new Dealer();
        Table table = new Table(players);
        GameState gameState = new GameState(table);

        dealer.dealHands(players, 2);

        assertEquals(true, table.pot().potSize().equals(new Chip(0)));
        Action.bet(new Chip(100), gameState);

        assertEquals(true, table.pot().potSize().equals(new Chip(100))); // potが正しく変化していることを確認
        assertEquals(true, gameState.betState().getLargestBet().equals(new Chip(100))); // largestBetSizeが100であることを確認
        assertEquals(1, gameState.turnState().lenOfDoneDeque()); // 終了済みのアクションが1つあることを確認
        assertEquals(1, gameState.turnState().lenOfToDoDeque()); // アクションが1つ残っていることを確認
    }

    @Test
    void testBetCall() {
        Players players = new Players();
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        players.addPlayer(player1);
        players.addPlayer(player2);

        Dealer dealer = new Dealer();
        Table table = new Table(players);
        GameState gameState = new GameState(table);

        dealer.dealHands(players, 2);

        Action.bet(new Chip(100), gameState);
        assertEquals(true, table.pot().potSize().equals(new Chip(100)));

        Action.call(gameState);
        assertEquals(true, table.pot().potSize().equals(new Chip(200))); // potが正しく変化していることを確認
        assertEquals(true, gameState.betState().getLargestBet().equals(new Chip(100))); // largestBetSizeが100であることを確認
        assertEquals(2, gameState.turnState().lenOfDoneDeque()); // 終了済みのアクションが2つあることを確認
        assertEquals(0, gameState.turnState().lenOfToDoDeque()); // アクションが残っていないことを確認

    }

    @Test
    void testBetRaiseCallCall() {
        Players players = new Players();
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        Player player3 = new Player("player3", new Chip(1000));

        players.addPlayer(player1);
        players.addPlayer(player2);
        players.addPlayer(player3);

        Dealer dealer = new Dealer();
        Table table = new Table(players);
        GameState gameState = new GameState(table);

        dealer.dealHands(players, 2);

        Action.bet(new Chip(100), gameState);
        assertEquals(true, table.pot().potSize().equals(new Chip(100)));

        Action.raise(new Chip(300), gameState);
        assertEquals(true, table.pot().potSize().equals(new Chip(400))); // potが正しく変化していることを確認
        assertEquals(true, gameState.betState().getLargestBet().equals(new Chip(300))); // largestBetSizeが300であることを確認
        assertEquals(1, gameState.turnState().lenOfDoneDeque()); // 終了済みのアクションがactionQueueに移動していることを確認
        assertEquals(2, gameState.turnState().lenOfToDoDeque()); // 2つのアクションが残っていることを確認

        Action.call(gameState);
        Action.call(gameState);
        assertEquals(true, table.pot().potSize().equals(new Chip(900))); // potが正しく変化していることを確認
        assertEquals(300, gameState.betState().getLargestBet().hashCode());
        // // アクションが閉じた際のlargestBetSizeが0であることを確認
        assertEquals(3, gameState.turnState().lenOfDoneDeque()); // 終了済みのアクションが3つ
        assertEquals(0, gameState.turnState().lenOfToDoDeque()); // 0個のアクションが残っていることを確認

    }

    @Test
    void testBetFold() {
        Players players = new Players();
        Player player1 = new Player("player1", new Chip(1000));
        Player player2 = new Player("player2", new Chip(1000));
        players.addPlayer(player1);
        players.addPlayer(player2);

        Dealer dealer = new Dealer();
        Table table = new Table(players);
        GameState gameState = new GameState(table);

        dealer.dealHands(players, 2);

        Action.bet(new Chip(100), gameState);
        Action.fold(gameState);
        assertEquals(true, player2.stack().equals(new Chip(1000))); // stackが正しく変化していることを確認
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
        Table table = new Table(players);
        GameState gameState = new GameState(table);

        dealer.dealHands(players, 2);

        Action.bet(new Chip(100), gameState);
        Action.raise(new Chip(300), gameState);
        Action.fold(gameState);

        assertEquals(true, player1.stack().equals(new Chip(900))); // stackが正しく変化していることを確認
        assertEquals(true, player2.stack().equals(new Chip(1100)));
        assertEquals(true, table.pot().potSize().equals(new Chip(0))); // potが0になっていることを確認

    }

}
