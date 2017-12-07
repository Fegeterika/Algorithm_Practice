"""
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
"""
import math

class Solution(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if (num <= 1):
            return False
        
        total = 1
        for div in range(2, int(math.sqrt(num) + 1)):
            if (num % div == 0):
                if (div != num / div):
                    total += div + (num / div)
                else:
                    total += div
            div += 1
        
        if (total == num):
            return True
        else:
            return False
