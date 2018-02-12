/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String substr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            while (index < substr.length() && index < strs[i].length() && substr.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            substr = substr.substring(0, index);
        }
        return substr;
    }
}
