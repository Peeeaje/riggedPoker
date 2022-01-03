package com.peeeaje.evaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonUnique5Creator {
    private NonUnique5Creator() {
    }

    private static int[] nonUnique5 = new int[4888];
    private static List<Integer> primeProductList = new ArrayList<>();
    private static int[] primeList = new int[] { 41, 37, 31, 29, 23, 19, 17, 13, 11, 7, 5, 3, 2 };
    static {
        setPrimeProductList();
        setNonUnique5();
    }

    protected static int getStrength(int valueProduct) {
        int index = getIndexFromPrimeProductList(valueProduct);
        return nonUnique5[index];
    }

    private static int getIndexFromPrimeProductList(int value) {
        return Collections.binarySearch(primeProductList, value);
    }

    private static void setPrimeProductList() {
        setQuadsPrimeProduct();
        setFullHousePrimeProduct();
        setThreeOfAKindPrimeProduct();
        setTwoPairPrimeProduct();
        setOnePairPrimeProduct();
        Collections.sort(primeProductList);
    }

    private static void setNonUnique5() {
        setQuadsNonUnique5();
        setFullHouseNonUnique5();
        setThreeOfAKindNonUnique5();
        setTwoPairNonUnique5();
        setOnePairNonUnique5();
    }

    // TODO: 一連のコードをもっと綺麗には書けそうだが、現状速度的には問題ない
    private static void setQuadsPrimeProduct() {
        // iがquads, jはhigh card
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (i == j) {
                    continue;
                }

                int valueProduct = primeList[i] * primeList[i] * primeList[i] * primeList[i] * primeList[j];
                primeProductList.add(valueProduct);
            }
        }
    }

    private static void setFullHousePrimeProduct() {
        // iがthree of a kind, jはpair
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (i == j) {
                    continue;
                }

                int valueProduct = primeList[i] * primeList[i] * primeList[i] * primeList[j] * primeList[j];
                primeProductList.add(valueProduct);
            }
        }
    }

    private static void setThreeOfAKindPrimeProduct() {
        // iがthree of a kind, j, kはhigh card
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = j + 1; k < 13; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int valueProduct = primeList[i] * primeList[i] * primeList[i] * primeList[j] * primeList[k];
                    primeProductList.add(valueProduct);
                }
            }
        }
    }

    private static void setTwoPairPrimeProduct() {
        // iとjはpair, kはhigh card
        for (int i = 0; i < 12; i++) {
            for (int j = i + 1; j < 13; j++) {
                for (int k = 0; k < 13; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int valueProduct = primeList[i] * primeList[i] * primeList[j] * primeList[j] * primeList[k];
                    primeProductList.add(valueProduct);
                }
            }
        }
    }

    private static void setOnePairPrimeProduct() {
        // iはpair, j, k, lはhigh card
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = j + 1; k < 12; k++) {
                    for (int l = k + 1; l < 13; l++) {
                        if (i == j || i == k || i == l || j == k || j == l || k == l) {
                            continue;
                        }
                        int valueProduct = primeList[i] * primeList[i] * primeList[j] * primeList[k] * primeList[l];
                        primeProductList.add(valueProduct);
                    }
                }
            }
        }
    }

    private static void setQuadsNonUnique5() {
        // iがquads, jはhigh card
        int strength = 11;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (i == j) {
                    continue;
                }
                int valueProduct = primeList[i] * primeList[i] * primeList[i] * primeList[i] * primeList[j];
                int index = getIndexFromPrimeProductList(valueProduct);
                nonUnique5[index] = strength++;
            }
        }
    }

    private static void setFullHouseNonUnique5() {
        // iがthree of a kind, jはpair
        int strength = 167;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                if (i == j) {
                    continue;
                }
                int valueProduct = primeList[i] * primeList[i] * primeList[i] * primeList[j] * primeList[j];
                int index = getIndexFromPrimeProductList(valueProduct);
                nonUnique5[index] = strength++;
            }
        }
    }

    private static void setThreeOfAKindNonUnique5() {
        // iがthree of a kind, j, kはhigh card, rankについてj > k
        int strength = 1610;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = j + 1; k < 13; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int valueProduct = primeList[i] * primeList[i] * primeList[i] * primeList[j] * primeList[k];
                    int index = getIndexFromPrimeProductList(valueProduct);
                    nonUnique5[index] = strength++;
                }
            }
        }
    }

    private static void setTwoPairNonUnique5() {
        // iとjはpair, kはhigh card, rankについてi > j
        int strength = 2468;
        for (int i = 0; i < 12; i++) {
            for (int j = i + 1; j < 13; j++) {
                for (int k = 0; k < 13; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int valueProduct = primeList[i] * primeList[i] * primeList[j] * primeList[j] * primeList[k];
                    int index = getIndexFromPrimeProductList(valueProduct);
                    nonUnique5[index] = strength++;
                }
            }
        }
    }

    private static void setOnePairNonUnique5() {
        // iはpair, j, k, lはhigh card, rankについてj > k > l
        int strength = 3326;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = j + 1; k < 12; k++) {
                    for (int l = k + 1; l < 13; l++) {
                        if (i == j || i == k || i == l || j == k || j == l || k == l) {
                            continue;
                        }
                        int valueProduct = primeList[i] * primeList[i] * primeList[j] * primeList[k] * primeList[l];
                        int index = getIndexFromPrimeProductList(valueProduct);
                        nonUnique5[index] = strength++;
                    }
                }
            }
        }
    }
}
