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
    public ListNode reverseBetween(final ListNode head, int l, final int r) {
        int d = r - l + 1;
        final ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        
        while (l-- > 1) {
            cur = cur.next;
        }

        ListNode prev = null, right = cur.next, left = cur;
        cur = cur.next;
        while (cur != null && d-- > 0) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        left.next = prev;
        right.next = cur;

        return dummy.next;
    }
}