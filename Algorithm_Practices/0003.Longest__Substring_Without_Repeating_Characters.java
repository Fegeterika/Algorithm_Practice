/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        HashMap<Character, Integer> charBuffer = new HashMap<Character, Integer>();
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(charBuffer.containsKey(s.charAt(i))) {
                j = Math.max(charBuffer.get(s.charAt(i)) + 1, j);
            }
            maxSize = Math.max(i - j + 1, maxSize);
            charBuffer.put(s.charAt(i), i);
        }
        return maxSize;
    }
}
