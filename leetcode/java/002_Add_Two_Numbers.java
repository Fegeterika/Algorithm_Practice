/* 
2. Add Two Numbers / Medium

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode currL1 = l1, currL2 = l2, currSum = sum;
                
        while(currL1 != null || currL2 != null) {
            int val1 = currL1 != null ? currL1.val : 0;
            int val2 = currL2 != null ? currL2.val : 0;
            
            int tempSum = currSum.val + val1 + val2;
            
            currSum.val = tempSum % 10;
            
            if(currL1 != null) currL1 = currL1.next;
            if(currL2 != null) currL2 = currL2.next;
            
            if(currL1 == null && currL2 == null && tempSum / 10 == 0) {
                break;
            }

            currSum.next = new ListNode(tempSum / 10);
            currSum = currSum.next;
        }
        
        return sum;
    }
}
