"""
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

"""
class Solution:
    def partition(self, s):
        res = []
        self.backtrack(res, [], s, 0)
        return res
    
    def backtrack(self, res, temp, s, start):
        if (start == len(s)):
                res.append(temp[:])
        for i in range(start, len(s)):
            if (self.is_palindrome(s, start, i)):
                temp.append(s[start:i + 1])
                self.backtrack(res, temp, s, i + 1)
                temp.pop()
    
    def is_palindrome(self, s, left, right):
        while (left < right):
            if (s[left] != s[right]):
                return False
            left += 1
            right -= 1
        return True
