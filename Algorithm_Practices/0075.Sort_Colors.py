"""
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
"""
# One-pass solution
class Solution:
    def sortColors(self, nums):
        i, j, x = 0, len(nums) - 1, 0
        while (x <= j):
            if nums[x] == 0 and x != i:
                self.swap(nums, x, i)
                i += 1
                x -= 1
            elif nums[x] == 2 and x != j:
                self.swap(nums, x, j)
                j -= 1
                x -= 1
            x += 1
    
    def swap(self, nums, a, b):
        temp = nums[b]
        nums[b] = nums[a]
        nums[a] = temp
        
# Two-pass solution
class Solution:
    def sortColors(self, nums):
        mapping = {}
        for num in nums:
            mapping[num] = mapping.get(num, 0) + 1
        c = 0
        for k, v in mapping.items():
            for i in range(0, v):
                nums[c + i] = k
            c += v
