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


// S1
// reverse
// remove Nth node
// reverse

// S2
// count size
// start from dummyNode [0] remove size - n Node

// basic Success
// size = 1;
// n == size

class Solution {
    public ListNode removeNthFromEnd(final ListNode head, int n) {
        int removeIndex = this.size(head) - n;

        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        int i = 0;
        while (cur != null) {
            if (i == removeIndex) {
                cur.next = cur.next.next;
            }
            i++;
            cur = cur.next;
        }
        return dummy.next;
    }

    private int size(final ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }
}
