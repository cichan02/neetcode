/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        if (size == n) {
            return head.next;
        }

        ListNode prev = null;
        curr = head;
        int r = size - n;
        while (r != 0) {
            prev = curr;
            curr = curr.next;
            r--;
        }

        if (curr != null && prev != null) {
            prev.next = curr.next;
        }
        return head;
    }
}
