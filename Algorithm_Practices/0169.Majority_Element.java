/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            if (cnt.get(num) > nums.length / 2) return num;
        }
        return 0;
    }
}
