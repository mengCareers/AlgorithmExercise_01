package Sorting;


import LinkedList.ListNode;

/* 147.Insertion Sort List
Sort List using Insertion Sort
 * Thought Process:
similart to sort play cards in game, insert cur into sorted part properly
e.g. 
3| -> 1 -> 7 -> 4
1 -> 3| -> 7 -> 4
1 -> 3 -> 7| -> 4
1 -> 3 -> 4 -> 7|
 * Get:
- MLE may occur when list not be finished with null
- dummy.next != head initially if we ought to return new head
- cur as the ptr, and it should be inserted between pre and pre.next
remember to save cur.next first and set pre = dummy every time
 */

/**
 *
 * @author xinrong
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        
        ListNode d = new ListNode(0);
//      d.next = head; With it, Memory Limited Exceeded
//      MLE may occur when list not be finished with null
        ListNode cur = head;
        ListNode pre = d;
        ListNode nxt = null;        
       
        while (cur != null) {
            nxt = cur.next;
            while (pre.next != null && pre.next.val < cur.val)
                pre = pre.next;
            cur.next = pre.next;                      
            pre.next = cur;
            pre = d; //!!!
            cur = nxt;
        }
        
        return d.next;
        
    }
}
