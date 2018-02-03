package LinkedList;


import LinkedList.ListNode;

/*
input : l1, l2
output: sum of n1 and n2 that l1 and l2 represent reversely 
 * Thought Process:
to start from the front, if > 10, add 1 to next digit 
 * Get:
 if > 10, add val % 10 to this digit, add val / 10 to next digit
 p1 = l1, p2 = l2
 * 
 */

/**
 *
 * @author xinrong
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dhead = new ListNode(0);
        ListNode cur = dhead;
        ListNode p1 = l1, p2 =l2;
        int val = 0;
        while (p1 != null || p2 != null) {
            val += (p1 == null) ? 0 : p1.val;
            val += (p2 == null) ? 0 : p2.val;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
            val = val / 10; // so we dont need carry
        }       
        if (val != 0)
            cur.next = new ListNode(1);
        return dhead.next;
    }
}
