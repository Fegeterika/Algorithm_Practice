/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        while (n > 0 && (n == 1 || n % 3 == 0)) {
            if (n == 1) return true;
            n = n / 3;
        }
        return false;
    }
}

/*
public class Solution {
public boolean isPowerOfThree(int n) {
    // 1162261467 is largest power of three that fits inside 32bit Integer
    return (n > 0 && 1162261467 % n == 0);
}
*/
