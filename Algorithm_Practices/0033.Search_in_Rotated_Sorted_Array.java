/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
class Solution {
    public int search(int[] nums, int target) {
        // Perform binary search to find smallest element
        int low = 0, high = nums.length - 1, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // Perform second binary search to find the value
        int rot = low;
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            int rm = (mid + rot) % nums.length;
            if (nums[rm] == target) {
                return rm;
            } else if (nums[rm] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
