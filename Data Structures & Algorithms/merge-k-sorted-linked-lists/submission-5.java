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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int m =  l + (r - l) / 2 ;
        return mergeTwoLists(divide(lists, l, m), divide(lists, m + 1, r));
    }

    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (first != null && second != null) {
            if (first.val < second.val) {
                ListNode tmp = first.next;
                first.next = null;
                cur.next = first;
                first = tmp;
            } else {
                ListNode tmp = second.next;
                second.next = null;
                cur.next = second;
                second = tmp;
            }
            cur = cur.next;
        }

        cur.next = first != null ? first : second;

        return dummy.next;
    }
}
