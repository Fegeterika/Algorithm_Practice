"""
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
"""
class Solution:
    def combinationSum2(self, candidates, target):
        res = []
        candidates.sort()
        self.backtrack(res, [], candidates, target, 0)
        return res
    
    def backtrack(self, res, temp, nums, target, start):
        if target == 0:
            res.append(temp[:])
        for i in range(start, len(nums)):
            if (target - nums[i] < 0):
                break
            if (i > start and nums[i] == nums[i - 1]):
                continue
            temp.append(nums[i])
            target -= nums[i]
            self.backtrack(res, temp, nums, target, i + 1)
            target += nums[i]
            temp.pop()
