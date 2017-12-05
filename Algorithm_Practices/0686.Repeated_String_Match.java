/*
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
*/

class Solution {
    public int repeatedStringMatch(String A, String B) {
        String rep = A;
        for (int cnt = 1; cnt <= B.length() / A.length() + 2; cnt++) {
            if (rep.indexOf(B) != -1) {
                return cnt;
            } else {
                rep += A;
            }
        }
        return -1;
    }
}
