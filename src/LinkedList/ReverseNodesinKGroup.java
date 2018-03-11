package LinkedList;


import LinkedList.ListNode;

/* Q :25. Reverse Nodes in k-Group
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.

For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
 * Get:
We aim to reverse list group by gruop,
Within a group, there should be s -> ... -> e, we reverse ...
    that is reverse(ListNode s, ListNode e)
For the whole list,
    we adjust s each time
 * 
 */
/**
 *
 * @author xinrong
 */
public class ReverseNodesinKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dhead = new ListNode(0);
        dhead.next = head;
        ListNode s = dhead;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                s = reverse(s, head.next);
                head = s.next;
            } else {
                head = head.next;
            }
        }

        return dhead.next;
    }

    private ListNode reverse(ListNode s, ListNode e) {
        ListNode cur = s.next;
        ListNode pre = s;
        ListNode fst = s.next;
        ListNode nxt = null;
        while (cur != e) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        s.next = pre;
        fst.next = e;
        return fst;
    }

}
