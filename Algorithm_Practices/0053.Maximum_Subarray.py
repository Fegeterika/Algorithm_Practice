"""
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
"""
class Solution:
    def maxSubArray(self, nums):
        if (len(nums) < 1):
            return 0
        
        dp = [0 for x in range(0, len(nums))]
        dp[0] = nums[0]
        maxNum = nums[0]
        
        for i in range(1, len(nums)):
            if (0 > dp[i - 1]):
                dp[i] = nums[i]
            else:
                dp[i] = dp[i - 1] + nums[i]
            maxNum = max(maxNum, dp[i])
        
        return maxNum
