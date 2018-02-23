"""

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
"""
class Solution:
    def searchRange(self, nums, target):
        if (len(nums) == 1 and nums[0] == target):
            return [0, 0]
        res = []        
        # First binary search to find left boundary
        left, right = 0, len(nums) - 1
        while (left < right):
            mid = (left + right) // 2
            if (nums[mid] < target):
                left = mid + 1
            else:
                right = mid
        
        # Return [-1, -1] if not found
        res.append(left)
        if (len(nums) == 0 or nums[res[0]] != target):
            return [-1, -1]
        
        # Second binary search to find right boundary
        left, right = 0, len(nums) - 1
        while (left < right):
            mid = (left + right + 1) // 2
            if (nums[mid] <= target):
                left = mid
            else:
                right = mid - 1
        
        res.append(right)
        return res
