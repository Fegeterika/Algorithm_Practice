/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/

class Solution {
    // Using bit manipulation to eliminate loops
    // num & (num - 1) == 0 checks if number is power of 2
    // 0x55555555 has 1 bit only on odd positions, which means the number is a power of 4
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }
    
    // Using iterations
    /*public boolean isPowerOfFour(int num) {
        if (num == 1) { return true; }
        while (num > 0 && num % 4 == 0) {
            if (num == 4) { return true; }
            num = num / 4;
        }
        return false; 
    }*/
}
