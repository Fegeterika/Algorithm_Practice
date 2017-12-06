"""
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        # Check if head is not null
        if (head == None):
            return True
        
        # Advance two pointers (one at half the pace of the other)
        mid = head
        end = head
        advMid = False
        while (end != None):
            end = end.next
            if (advMid == True):
                mid = mid.next
                advMid = False
            else:
                advMid = True
        
        # Reverse second half of the linked list using mid pointer
        secondHead = self.reverseList(mid)
        
        # Walk along two lists and check if values are same
        while (head != None and secondHead != None):
            if (head.val != secondHead.val):
                return False
            head = head.next
            secondHead = secondHead.next
        
        # Return true if all values are same to the end
        return True
        
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        prev = None
        print("revsersing list")
        while (head != None):
            temp = head.next
            head.next = prev
            prev = head
            head = temp
        return prev
        
        
