/*
 * Thought Process:
 * 
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class PlusOneLinkedList {

    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null; // index of last non-9 digit
        while (cur.next != null) {
            if (cur.val != 9) {
                pre = cur;
            }
            cur = cur.next;
        }
        if (cur.val < 9) {
            cur.val++;
        } else {
            if (pre == null) {
                pre = new ListNode(1);
                pre.next = head;
                head = pre;
            } else {
                pre.val++;
            }
            ListNode ptr = pre.next;
            while (ptr != null) {
                ptr.val = 0;
                ptr = ptr.next;
            }
        }
        return head;
    }
}
