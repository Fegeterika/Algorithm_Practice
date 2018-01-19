/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int limit = haystack.length();
        for (int i = 0; i < limit; i++) {
            if (haystack.charAt(i) == needle.charAt(0) && i + needle.length() <= limit) {
                int j = 1;
                while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                    j += 1;
                }
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }
}
