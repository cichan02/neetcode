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
        int l = lists.length;
        if (l == 0) {
            return null;
        }
        if (l == 1) {
            return lists[0];
        }
        if (l == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        
        int m = l / 2;
        ListNode[] first = Arrays.copyOfRange(lists, 0, m);
        ListNode[] second = Arrays.copyOfRange(lists, m, l);
        
        return mergeTwoLists(mergeKLists(first), mergeKLists(second));
    }

    public ListNode mergeTwoLists(ListNode first, ListNode second) {
       ListNode dummy = new ListNode();
       ListNode prevHead = dummy;

       while (first != null && second != null) {
           if (first.val < second.val) {
               ListNode tmp = first.next;
               first.next = null;
               dummy.next = first;
               first = tmp;
           } else {
               ListNode tmp = second.next;
               second.next = null;
               dummy.next = second;
               second = tmp;
           }
           dummy = dummy.next;
       }

       dummy.next = first != null ? first : second;

        return prevHead.next;
    }
}
