"""
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
"""
class Solution:
    def firstMissingPositive(self, nums):
        for i in range(0, len(nums)):
            while (nums[i] > 0 and nums[i] - 1 < len(nums) and nums[nums[i] - 1] != nums[i]):
                temp = nums[nums[i] - 1]
                nums[nums[i] - 1] = nums[i]
                nums[i] = temp
        
        for i in range(0, len(nums)):
            if nums[i] - 1 != i:
                return i + 1
        
        return len(nums) + 1
