"""
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
"""
class Solution:
    def lengthOfLIS(self, nums):
        if len(nums) == 0:
            return 0
        
        dp = [1 for x in range(len(nums))]
        dp_max = 1
        
        for i in range(1, len(nums)):
            j = i - 1
            while (j >= 0):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
                j -= 1
            dp_max = max(dp_max, dp[i])
        
        return dp_max
