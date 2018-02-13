/* 328. Odd Even Linked List
Attention:
    if head == null || head.next == null
    while (to avoid exception)
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
        ListNode o, e, onxt, enxt, s;
        o = head;
        e = o.next;
        s = e;
        while (e != null && e.next!= null && o != null && o.next != null) {
            onxt = o.next.next;
            o.next = onxt;
            o = onxt;
            
            enxt = e.next.next;
            e.next = enxt;
            e = enxt;
        }
        o.next = s;
        return head;
    }
}
