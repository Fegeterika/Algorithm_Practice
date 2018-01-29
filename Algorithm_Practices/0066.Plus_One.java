/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] resForAllNines = new int[digits.length + 1];
        resForAllNines[0] = 1;
        return resForAllNines;
    }
}

/*
class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i - 1]++;
                res[i + 1] = 0;
            } else {
                res[i + 1] = digits[i];
            }
        }
        
        if (digits[0] == 10) {
            res[1] = 0;
            res[0] = 1;
            return res;
        } else {
            res[1] = digits[0];
            return Arrays.copyOfRange(res, 1, res.length);
        }
    }
}
*/
