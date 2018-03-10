"""
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
"""
from queue import PriorityQueue

class Solution:
    def kthSmallest(self, matrix, k):
        pqueue = PriorityQueue()
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                pqueue.put(matrix[i][j])
        
        for i in range(k - 1):
            ans = pqueue.get()
        
        return pqueue.get()
