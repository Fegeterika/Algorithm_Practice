/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] < 0) continue;
            temp.add(nums[i]);
            backtrack(res, temp, nums, target - nums[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
