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
    public void reorderList(ListNode head) {
        ListNode beforeMedium = beforeMedium(head);

        ListNode medium = beforeMedium.next;
        beforeMedium.next = null;

        ListNode reverse = reverseList(medium);

        mergeTwoLists(head, reverse);
    }

    private ListNode beforeMedium(final ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(final ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    private void mergeTwoLists(final ListNode list1, final ListNode list2) {
        ListNode l1 = list1, l2 = list2;
        while (l1 != null && l2 != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l2.next = tmp1;
            l1.next = l2;

            l1 = tmp1;
            l2 = tmp2;             
        }
    } 
}
