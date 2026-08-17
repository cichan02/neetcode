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

        Queue<ListNode> merged = new LinkedList<>();
        for (ListNode list: lists) {
            merged.add(list);
        }
        while (merged.size() > 1) {
            ListNode l1 = merged.poll();
            ListNode l2 = merged.poll();
            merged.add(mergeTwoLists(l1, l2));
        }
        return merged.poll();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode tmp = list1.next;
                list1.next = null;
                cur.next = list1;
                list1 = tmp;
            } else {
                ListNode tmp = list2.next;
                list2.next = null;
                cur.next = list2;
                list2 = tmp;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
