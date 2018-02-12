/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        // buy0 = buy at i, buy1 = buy at i - 1
        // sell0 = sell at i, sell1 = sell at i - 1, sell2 = sell at i - 2
        int buy0 = -prices[0], buy1 = -prices[0];
        int sell0 = 0, sell1 = 0, sell2 = 0;
        
        for (int i = 1; i < prices.length; i++) {
            buy0 = Math.max(sell2 - prices[i], buy1);
            sell0 = Math.max(buy1 + prices[i], sell1);
            buy1 = buy0;
            sell2 = sell1;
            sell1 = sell0;
        }
        
        return sell0;
    }
}
