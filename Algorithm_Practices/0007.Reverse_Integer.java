/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int rem = x % 10;
            result = result * 10 + rem;
            x = x / 10;
            if (result / 10 * 10 != result - rem) { return 0; }
        }
        return result;
    }
}
