/* 203.Remove Linked List Elements
input : head, val
output: new head after remove all elements value val
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class RemoveLinkedListElements {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }            
            else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
