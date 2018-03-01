/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return false;
        boolean[] dp = new boolean[s.length()];
        
        // contains() method for List is O(n), build a hashset for lookup
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        
        if (dict.contains(String.valueOf(s.charAt(0)))) dp[0] = true;
        
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= -1; j--) {
                if (j > -1 && dp[j] && dict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                } else if (j == -1 && dict.contains(s.substring(0, i + 1))) {
                    dp[i] = true;
                }
            }
        }
        
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + ", ");
        }
        
        return dp[dp.length - 1];
    }
}
