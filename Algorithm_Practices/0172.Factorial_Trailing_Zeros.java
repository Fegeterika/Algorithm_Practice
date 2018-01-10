/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/
class Solution {
    public int trailingZeroes(int n) {
        int zeros = 0;
        while (n != 0) {
            int temp = n / 5;
            zeros += temp;
            n = temp;
        }
        return zeros;
    }
}
