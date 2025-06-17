package com.ollierupprecht.dsa.leetcode;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = prices[prices.length - 1];

        for (int i = 0, j = prices.length-1; i < prices.length && j > 0; i++, j--) {
            if (prices[i] <= buy) {
                buy = prices[i];
                System.out.println("buy - " + buy);
            }
            if (prices[j] >= sell) {
                sell = prices[j];
                System.out.println("sell - " + sell);
            }
            if (i == j) break;
        }

        if ((sell - buy) < 0) return 0;

        return sell - buy;
    }
}
