package com.peeeaje.evaluator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlushHashCreator {
    private FlushHashCreator() {
    }

    private static HashMap<Integer, Integer> bitStrengthMap = new HashMap<>();

    // str8 flushの判定に, AKQJT, KQJT9, ..., A5432にそれぞれ対応
    private static List<Integer> str8FlushBit = new ArrayList<>(
            Arrays.asList(7936, 3968, 1984, 992, 496, 248, 124, 62, 31, 4111));

    public static Map<Integer, Integer> getBitStrengthMap() {
        return bitStrengthMap;
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

    private static boolean isStraightFlush(int integer) {
        return str8FlushBit.indexOf(integer) != -1;
    }

    private static void setStraightFlush(int integer) {
        bitStrengthMap.put(integer, str8FlushBit.indexOf(integer) + 1);
    }

    private static void setNonStraightFlush(int integer, int strength) {
        bitStrengthMap.put(integer, strength);
    }

    static {
        int strength = 1599;

        for (int i = 0; i < (Math.pow(2, 13)); i++) {
            int numOfCards = countNumOfCards(i);

            // bit探索で13枚から5枚を選び、そのbit(int)に対して強さを割り当てる
            if (numOfCards == 5) {
                if (isStraightFlush(i)) {
                    setStraightFlush(i);
                } else {
                    setNonStraightFlush(i, strength);
                    strength--;
                }
            }

        }
    }
}
