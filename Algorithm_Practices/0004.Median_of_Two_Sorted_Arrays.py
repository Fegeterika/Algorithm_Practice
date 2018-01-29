"""
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
"""
import sys

class Solution:
    def findMedianSortedArrays(self, left, right):
        # Handle edge cases
        if (left is None or right is None):
            return 0.0

        # Get length of each array
        m = len(left)
        n = len(right)

        # Let median be k-th element defined in terms of m and n (length of two arrays)
        # If combined length is odd, median is at (m + n + 1) // 2 == (m + n + 2) // 2
        # If combined length is even, median is avg of (m + n + 1) // 2 and (m + n + 2) // 2
        l = (m + n + 1) // 2
        r = (m + n + 2) // 2

        return (self.get_kth(left, 0, right, 0, l) + self.get_kth(left, 0, right, 0, r)) / 2

    def get_kth(self, left, start_l, right, start_r, k):
        # Get k-th element in combined array
        # Idea is to shrink array by getting rid of k/2 elements

        # If either one array is exausted (start == length - 1), return k-th number in remaining array
        if start_l >= len(left):
            return right[start_r + k - 1]

        if start_r >= len(right):
            return left[start_l + k - 1]
        
        # If k == 1, return first element
        if k == 1:
            return min(left[start_l], right[start_r])

        mid_l = sys.maxsize
        mid_r = sys.maxsize
        
        # Find (k/2)-th element of each array
        if start_l + (k // 2 - 1) < len(left):
            mid_l = left[start_l + k // 2 - 1]
        if start_r + (k // 2 - 1) < len(right):
            mid_r = right[start_r + k // 2 - 1]

        if mid_l < mid_r:
            # Since median of left array is smaller than median of right array,
            # Shrink left array to right and right array to left
            return self.get_kth(left, start_l + (k // 2), right, start_r, (k + 1) // 2)
        else:
            # Since median of right array is smaller than median of left array,
            # Shrink right array to right and left array to left
            return self.get_kth(left, start_l, right, start_r + (k // 2), (k + 1) // 2)
