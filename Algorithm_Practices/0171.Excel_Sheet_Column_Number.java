/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/
class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (char letter : s.toCharArray()) {
            if (res == 0) {
                res += Character.getNumericValue(letter) - 9;
            } else {
                res = res * 26;
                res += Character.getNumericValue(letter) - 9;
            }
        }
        return res;
    }
}
