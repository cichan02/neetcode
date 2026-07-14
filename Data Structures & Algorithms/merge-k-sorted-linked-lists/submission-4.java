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

        Queue<ListNode> nodes = new LinkedList<>(Arrays.asList(lists));
        while (nodes.size() > 1) {
            for (int i = 0; i < nodes.size(); i += 2) {
                ListNode first = nodes.poll();
                ListNode second = nodes.poll();
                nodes.add(mergeTwoLists(first, second));
            }
        }
        return nodes.peek();
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
