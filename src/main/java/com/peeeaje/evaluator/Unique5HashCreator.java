package com.peeeaje.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Unique5HashCreator {
    private Unique5HashCreator() {
    }

    private static HashMap<Integer, Integer> unique5 = new HashMap<>();

    // str8の判定に, AKQJT, KQJT9, ..., A5432にそれぞれ対応
    private static List<Integer> str8Bit = new ArrayList<>(
            Arrays.asList(7936, 3968, 1984, 992, 496, 248, 124, 62, 31, 4111));

    public static Map<Integer, Integer> getUnique5() {
        return unique5;
    }

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

    private static boolean isStraight(int integer) {
        return str8Bit.indexOf(integer) != -1;
    }

    private static void setStraight(int integer) {
        unique5.put(integer, str8Bit.indexOf(integer) + 1600);
    }

    private static void setHighCard(int integer, int strength) {
        unique5.put(integer, strength);
    }

    static {
        int strength = 7462;

        for (int i = 0; i < (Math.pow(2, 13)); i++) {
            int numOfCards = countNumOfCards(i);

            // bit探索で13枚から5枚を選び、そのbit(int)に対して強さを割り当てる
            if (numOfCards == 5) {
                if (isStraight(i)) {
                    setStraight(i);
                } else {
                    setHighCard(i, strength);
                    strength--;
                }
            }

        }
    }
}
