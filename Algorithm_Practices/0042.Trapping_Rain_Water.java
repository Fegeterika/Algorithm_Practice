/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int vol = 0;

        while (left <= right) {
            if (height[left] >= height[right]) {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    vol += rightMax - height[right];
                }
                right -= 1;
            } else {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    vol += leftMax - height[left];
                }
                left += 1;
            }
        }

        return vol;
    }
}
