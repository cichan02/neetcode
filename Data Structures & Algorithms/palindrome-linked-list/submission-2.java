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
    public boolean isPalindrome(ListNode head) {
        ListNode beforeMedium = beforeMedium(head);

        ListNode m = beforeMedium.next;
        beforeMedium.next = null;

        ListNode reverse = reverseList(m);

        return isSame(head, reverse);
    }

    private ListNode beforeMedium(final ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow  = slow.next;
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

    private boolean isSame(final ListNode list1, final ListNode list2) {
        ListNode l1 = list1, l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}