"""
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
"""
class Solution:
    def productExceptSelf(self, nums):
        res = [1 for x in range(len(nums))]
        
        rolling = 1
        for i in range(1, len(nums)):
            rolling *= nums[i - 1]
            res[i] *= rolling
        
        rolling = 1
        for i in reversed(range(0, len(nums) - 1)):
            rolling *= nums[i + 1]
            res[i] *= rolling
        return res
