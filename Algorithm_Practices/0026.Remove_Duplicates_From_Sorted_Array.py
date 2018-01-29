"""
Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.
"""
class Solution:
    def removeDuplicates(self, nums):
        i = 0
        j = 0
        while (i < len(nums)):
            if i <= 0 or nums[i] != nums[i - 1]:
                nums[j] = nums[i]
                j += 1
            i += 1
        return j
