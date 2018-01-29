"""
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
 

Example:

Input: "cbbd"

Output: "bb"
"""
class Solution:
    def longestPalindrome(self, s):
        if len(s) < 2:
            return s
        
        max_length = ''
        for i in range(0, len(s) - 1):
            odd = self.getPalin(s, i, i)
            even = self.getPalin(s, i, i + 1)
            if len(odd) > len(even) and len(odd) > len(max_length):
                max_length = odd
            elif len(even) > len(odd) and len(even) > len(max_length):
                max_length = even
            
        return max_length
    
    def getPalin(self, s, i, j):
        while (i >= 0 and j < len(s) and s[i] == s[j]):
            i -= 1
            j += 1
        return s[i+1:j]
