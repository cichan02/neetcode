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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
        }
        return dummy.next;
    }
}