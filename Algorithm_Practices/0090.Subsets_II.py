"""
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
"""
class Solution:
    def subsetsWithDup(self, nums):
        res = []
        nums.sort()
        self.backtrack(res, [], nums, 0)
        return res
        
    def backtrack(self, res, temp, nums, start):
        res.append(temp[:])
        for i in range(start, len(nums)):
            if (i > start and nums[i] == nums[i - 1]):
                continue
            temp.append(nums[i])
            self.backtrack(res, temp, nums, i + 1)
            temp.pop()
