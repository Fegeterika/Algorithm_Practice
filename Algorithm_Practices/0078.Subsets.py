"""
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
"""
class Solution:
    def subsets(self, nums):
        nums.sort()
        res = []
        self.backtrack(res, [], nums, 0)
        return res
    
    def backtrack(self, res, temp, nums, start):
        res.append(temp[:])
        for i in range(start, len(nums)):
            temp.append(nums[i])
            self.backtrack(res, temp, nums, i + 1)
            temp.remove(nums[i])
