/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
*/
class Solution {
    public int findMaxLength(int[] nums) {
        int numOfOnes = 0;
        int maxLen = 0;
        // this map will map difference between 1s and 0s to smallest index
        Map<Integer, Integer> cacheDiff = new HashMap<>();
        cacheDiff.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) numOfOnes++;
            int numOfZeros = (i + 1) - numOfOnes;
            int diff = numOfOnes - numOfZeros;
            if (!cacheDiff.containsKey(diff)) {
                cacheDiff.put(diff, i);
            } else {
                maxLen = Math.max(maxLen, i - cacheDiff.get(diff));
            }
        }
        return maxLen;
    }
}
