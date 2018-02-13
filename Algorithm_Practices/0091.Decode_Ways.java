/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.equals("")) return 0;
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1; // Empty string has 1 way to decode
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {
            int prev = Integer.parseInt(s.substring(i - 1, i));
            int combined = Integer.parseInt(s.substring(i - 2, i));
            if (prev >= 1 && prev <= 9) {
                // if previous is 1 ~ 9, using i-th char by itself yields dp[i - 1] ways to decode
                dp[i] += dp[i - 1];
            }
            if (combined >= 10 && combined <= 26) {
                // if previous char and current char can be combined, it adds dp[i - 2] ways to decode
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[dp.length - 1];
    }
}
