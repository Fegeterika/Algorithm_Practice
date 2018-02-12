/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?


*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean advSlow = false;
        while (fast != null) {
            if (advSlow) slow = slow.next;
            fast = fast.next;
            advSlow = !advSlow;
            if (fast == slow) return true;
        }
        return false;
    }
}
