"""
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

"""
class Solution:
    def frequencySort(self, s):
        freq_cache = {}
        max_freq = 0
        for char in s:
            freq_cache[char] = freq_cache.get(char, 0) + 1
            max_freq = max(max_freq, freq_cache[char])
        
        temp = ['' for x in range(0, max_freq)]
        for k, v in freq_cache.items():
            temp[v - 1] += k * v
        
        res = ''
        for i in range(0, len(temp)):
            res += temp[len(temp) - i - 1]
            
        return res
