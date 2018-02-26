/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < cs.length; i++) {
            if (cnt.get(cs[i]) == 1) return i;
        }
        return -1;
    }
}
