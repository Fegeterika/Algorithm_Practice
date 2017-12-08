/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
*/
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minSoFar);
            minSoFar = Math.min(minSoFar, price);
        }
        return maxProfit;
    }
}
