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
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return dummy.next;
    }
}