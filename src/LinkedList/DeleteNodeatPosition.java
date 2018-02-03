/*
 * Thought Process:
 * if is root, delete it; if not, we have to get the prev pointer, then delete it
 * that is, modify the nextpointer of the node before it, to point to the node after it
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class DeleteNodeatPosition {

    void delete(Node head, int position) {
        if (position == 0) {
            head = head.next;
            return;
        }
        Node tmp = head;
        for (int i = 0; i < position - 1; i++) 
            tmp = tmp.next;
        Node next = tmp.next.next;
        tmp.next = next;
    }
}
