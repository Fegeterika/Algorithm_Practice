/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob1(nums, 0, nums.length - 1), rob1(nums, 1, nums.length));
    }
    
    public int rob1(int[] nums, int start, int end) {
        int rob = nums[start], nrob = 0, temp;
        for (int i = start + 1; i < end; i++) {
            temp = rob;
            rob = Math.max(nrob + nums[i], rob);
            nrob = temp;
        }
        return Math.max(rob, nrob);
    }
}
