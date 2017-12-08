"""
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
"""
class Solution:
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        left = 0
        right = len(s) - 1
        
        while (left < right):
            if (s[left] != s[right]):
                return self.isPalindrome(s, left, right - 1) or self.isPalindrome(s, left + 1, right)
            else:
                left += 1
                right -= 1
        
        return True
    
    def isPalindrome(self, word, left, right):
        """
        :type word: str, left: int, right: int
        :rtype: bool
        """
        while (left < right):
            if (word[left] != word[right]):
                return False
            left += 1
            right -= 1
        
        return True
