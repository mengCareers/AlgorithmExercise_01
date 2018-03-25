/*
 * Thought Process:
 * iterative OR recursive
 * when we call recursive func, we make sure the value passing is expected in next call
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class ReverseLinkedList {
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        head.next = null;
        return pre;
    }
   
    public Node reverse(Node head) {
        return reverse(head, null);
    }
    
    public Node reverse(Node curr, Node prev) {
        if (curr == null) return prev;
        
        Node next = curr.next;
        curr.next = prev;
        
        return reverse(next, curr);
    }
}
