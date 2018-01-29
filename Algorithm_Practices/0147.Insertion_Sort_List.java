/*
Sort a linked list using insertion sort.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode current = head.next;
        head.next = null;
        int i = 1;
        while (current != null) {
            ListNode next = current.next;
            head = insertNode(head, current, i);
            current = next;
            i += 1;
        }
        return head;
    }
    
    private ListNode insertNode(ListNode head, ListNode node, int i) {
        ListNode current = head;
        ListNode prev = null;
        while (i > 0) {
            if (current.val > node.val) {
                // If current node is greater than the node to be inserted...
                node.next = current;
                if (prev == null) {
                    // new node is smallest value, so make it the head
                    head = node;
                } else {
                    // Insert the node between prev and current
                    prev.next = node;
                }
                // Node is inserted, return
                return head;
            } else {
                // If not greater, move onto next one
                prev = current;
                current = current.next;
            }
            i -= 1;
        }
        // If node is not inserted until now, it should be the last node of the new linked list
        prev.next = node;
        node.next = null;
        return head;
    }
}
