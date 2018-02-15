/* 141 Linked List Cycle
 * Thought Process:
 * 
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null)
//            return false;
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s)
                return true;
        }
        return false;
    }
}
