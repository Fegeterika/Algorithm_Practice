/* 
20 - Valid Parenthesis / Easy

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

class Solution {
    public boolean isValid(String s) {
        String opener = "({[";
        String closer = ")}]";
                     
        // Use stack data structure to store opener brackets
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (opener.indexOf(s.charAt(i)) >= 0) {
                stack.push(s.charAt(i));
            } else if (closer.indexOf(s.charAt(i)) >= 0) {
                if (stack.empty() == true || stack.peek() != opener.charAt(closer.indexOf(s.charAt(i)))) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                // If character not in opener/closer is present return false
                return false;
            }
        }
        
        return stack.empty();
    }
}
