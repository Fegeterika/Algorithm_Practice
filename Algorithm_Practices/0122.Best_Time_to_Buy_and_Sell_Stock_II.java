/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            res += Math.max(prices[i + 1] - prices[i], 0);
        }
        return res;
    }
}
