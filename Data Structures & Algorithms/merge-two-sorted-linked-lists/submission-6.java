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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur  = dummy;

        while (list1 != null && list2 != null) {
            ListNode next;
            if (list1.val < list2.val) {
                next = list1.next;
                list1.next = null;
                cur.next = list1;
                list1 = next;
            } else {
                next = list2.next;
                list2.next = null;
                cur.next = list2;
                list2 = next;
            }
            cur = cur.next;
        }

        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }

        return dummy.next;
    }
}