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
    public void reorderList(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null && curr.next.next != null) {
            ListNode prevLast = curr;
            while (prevLast != null && prevLast.next != null && prevLast.next.next != null) {
                prevLast = prevLast.next;
            }

            ListNode next = curr.next, last = prevLast.next;
            curr.next = last;
            last.next = next;
            prevLast.next = null;
            curr = next;
        }
    }
}
