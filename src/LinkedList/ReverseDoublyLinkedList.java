/*
 * Thought Process:
 * 
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class ReverseDoublyLinkedList {

    void reverse(Node head) {
        Node temp = null;
        Node curr = head;
        while (curr != null) {
            temp = curr.previous;
            curr.previous = curr.next;
            curr.next = temp;
            curr = curr.previous;
        }
        if (temp != null) {
            head = temp.previous;
        }
    }

    class Node {

        int val;
        Node next;
        Node previous;

        Node(int val) {
            this.val = val;
            next = null;
            previous = null;
        }
    }
}
