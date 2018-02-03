package LinkedList;

/*
 *  Q:148. Sort List
sort a list in O(nlogn)
 *  Get : 
O(nlogn) -> binary search | Merge Sort
 */

/**
 *
 * @author xinrong
 */
public class SortList {
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null) 
            return head;
        
        // cut into 2 halves
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        
        // sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // merge l1 and l2
        return merge(l1, l2);     
    }
    
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }      
        if (l1 != null) 
            p.next = l1;
        if (l2 != null) 
            p.next = l2;
        
        return l.next;
    }
}
