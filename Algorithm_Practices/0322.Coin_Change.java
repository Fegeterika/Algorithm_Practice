/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] nums = new int[amount + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = -1;
            for (int amt : coins) {
                if (i - amt >= 0 && nums[i - amt] != -1 && nums[i] == -1) {
                    nums[i] = nums[i - amt] + 1;
                } else if (i - amt >= 0 && nums[i - amt] != -1 && nums[i] >= 0) {
                    nums[i] = Math.min(nums[i - amt] + 1 , nums[i]);
                }
            }
        }
        return nums[amount];
    }
}
