/* 328. Odd Even Linked List
Attention:
    ep = head;
    eh = ep;
    ep = ep.next;
    eh, head not moving with ep
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode op = head, ep = head.next, eh = ep;
        while (ep != null && ep.next != null) {
            ListNode ot = op.next.next;
            ListNode et = ep.next.next;
            op.next = ot;
            op = op.next;
            ep.next = et;
            ep = ep.next;
        }
        op.next = eh; // eh not moving with ep
        return head;
    }
}
