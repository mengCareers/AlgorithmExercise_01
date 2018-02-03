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
   
    public Node reverse(Node head) {
    /*    Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
     */   
        return reverse(head, null);
    }
    
    public Node reverse(Node curr, Node prev) {
        if (curr == null) return prev;
        
        Node next = curr.next;
        curr.next = prev;
        
        return reverse(next, curr);
    }
}
