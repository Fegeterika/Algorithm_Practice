"""
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.


Example 1:

Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
"""
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if (n == 1):
            return 1
        
        nums = [0 for x in range(0, n + 1)]
        nums[1] = 1
        nums[2] = 2
        
        for i in range (3, n + 1):
            nums[i] = nums[i - 1] + nums[i - 2]
        
        return nums[n]
