package com.peeeaje.evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.peeeaje.Player;
import com.peeeaje.card_related.Card;
import com.peeeaje.card_related.Cards;

public class Evaluator {
    private Map<Integer, Integer> flushes = FlushHashCreator.getFlushes();
    private Map<Integer, Integer> unique5 = Unique5HashCreator.getUnique5();

    public int getStrength(Cards hand) {
        if (hand.numOfCards() != 5) {
            throw new IllegalArgumentException("numOfCards must be 5");
        }

        if (isFlush(hand)) {
            // hand has flush
            int index = Evaluator.unique5Index(hand);
            return flushes.get(index);
        }

        else {
            int index = Evaluator.unique5Index(hand);
            if (unique5.get(index) != null) {
                // all 5 cards are different
                return unique5.get(index);
            } else {
                // all 5 cards are not different
                index = Evaluator.nonUnique5Index(hand);
                return NonUnique5Creator.getStrength(index);
            }
        }
    }

    public int getStrength(Cards hand, Cards board) {
        List<Cards> cardsList = get5CardsList(hand, board);

        int strength = 10000;
        for (Cards cards : cardsList) {
            strength = Math.min(getStrength(cards), strength);
        }
        return strength;
    }

    public Player judgeWinner(Cards board, Player player1, Player player2) {
        // return player but if it's draw return null
        Cards hand1 = player1.hand();
        Cards hand2 = player2.hand();

        int strength1 = getStrength(hand1, board);
        int strength2 = getStrength(hand2, board);

        if (strength1 > strength2) {
            return player1;
        } else if (strength1 < strength2) {
            return player2;
        } else {
            return null;
        }
    }

    private boolean isFlush(Cards hand) { // TODO: tempよりもいい命名があれば変えたい
        int temp = 61440;
        for (int bit : hand.getBitList()) {
            temp = temp & bit;
        }
        return temp != 0;
    }

    private List<Cards> get5CardsList(Cards hand, Cards board) {
        Cards cards = board;
        for (Card card : hand.getCards()) {
            cards.add(card);
        }

        List<Cards> cardsList = new ArrayList<>();
        for (int i = 0; i < (Math.pow(2, 7)); i++) {
            Cards fiveCards = new Cards();
            int numOfCards = countNumOfCards(i);

            if (numOfCards == 5) {
                for (int j = 0; j < 7; j++) {
                    if ((i >> j & 1) == 1) {
                        Card activeCard = cards.getCards().get(j);
                        fiveCards.add(activeCard);
                    }
                }
                cardsList.add(fiveCards);
            }
        }
        return cardsList;
    }

    // TODO: FlushHashCreator.javaからコピペしている、どこかいい置き場があればまとめてしまいたい
    private static int countNumOfCards(int integer) {
        String bitInteger = Integer.toBinaryString(integer);
        int numOfCards = 0;
        for (int j = 0; j < bitInteger.length(); j++) {
            if (bitInteger.charAt(j) == '1') {
                numOfCards++;
            }
        }
        return numOfCards;
    }

    private static int unique5Index(Cards hand) {
        int temp = 0;
        for (int bit : hand.getBitList()) {
            temp = temp | bit >> 16;
        }
        return temp;
    }

    private static int nonUnique5Index(Cards hand) {
        int temp = 1;
        for (int bit : hand.getBitList()) {
            temp *= 255 & bit;
        }
        return temp;
    }
}
