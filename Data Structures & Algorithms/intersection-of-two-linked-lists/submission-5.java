/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode u1 = headA, u2 = headB;
        while (u1 != u2) {
            u1 = u1 != null ? u1. next : headB;
            u2 = u2 != null ? u2. next : headA;
        }
        return u1;
    }
}