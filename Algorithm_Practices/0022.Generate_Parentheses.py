"""
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
"""
class Solution:
    def generateParenthesis(self, n):
        res = []
        self.backtrack(res, '', n, n)
        return res
    
    def backtrack(self, res, temp, n, c):
        if n <= 0:
            temp += ')' * c
            res.append(temp)
            temp = ''
        else:
            temp += '('
            self.backtrack(res, temp, n - 1, c)
            temp = temp[:len(temp) - 1]
            if c > n:
                temp += ')'
                self.backtrack(res, temp, n, c - 1)
                temp = temp[:len(temp) - 1]
            
