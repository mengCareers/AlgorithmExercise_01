package Sorting;


import LinkedList.ListNode;

/* Q: 148. Sort List in constant space complexity
 * Thought Process:
 * - How does it mean by constant space? 
     no other ds
 * Get: Using Merge Sort   
 cut first, then merge
 */

/**
 *
 * @author xinrong
 */
public class MergeSortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // that is cut
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }   
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) 
            p.next = l1;
        if (l2 != null) // l2 is a link
            p.next = l2;
        return l.next;  // l is 0
    }
}
