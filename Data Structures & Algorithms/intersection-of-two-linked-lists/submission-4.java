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
        boolean s1 = false, s2 = false;
        while (u1 != null && u2 != null) {
            if (u1 == u2) {
                return u1;
            }
            u1 = u1.next;
            u2 = u2.next;
            
            if (u1 == null && !s1) {
                u1 = headB;
                s1 = true;
            }
            
            if (u2 == null && !s2) {
                u2 = headA;
                s2 = true;
            }
        }
        return null;
    }
}