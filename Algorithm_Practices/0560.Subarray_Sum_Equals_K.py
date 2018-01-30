"""
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
"""
class Solution:
    def subarraySum(self, nums, k):
        cache, temp_sum, count = {0: 1}, 0, 0
        for num in nums:
            temp_sum += num
            count += cache.get(temp_sum - k, 0)
            cache[temp_sum] = cache.get(temp_sum, 0) + 1
        return count
        
        """
        This is O(n^2) solution
        
        count = 0

        for i in range(0, len(nums)):
            temp_sum = 0
            for j in range(i, len(nums)):
                temp_sum += nums[j]
                if temp_sum == k:
                    count += 1

        return count
        """
