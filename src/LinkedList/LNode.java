/*
 * Thought Process:
 * 
 */
package LinkedList;

/**
 *
 * @author xinrong
 */

public class LNode {
    int data;
    LNode right, down;
    LNode(int data) {
        this.data = data;
        right = null;
        down = null;
    }
}
