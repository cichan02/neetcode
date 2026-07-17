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
        //count size
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }

        //remove size - n 
        int r = size - n + 1;
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy, prev = null;
        while (r != 0) {
            prev = cur;
            cur = cur.next;
            r--;
        }
        prev.next = cur.next;
        return dummy.next;
    }
}
