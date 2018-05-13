/* 382.Linked List Random Node
Given a singly linked list, 
return a random node's value from the linked list. 
Each node must have the same probability of being chosen.
 * Thought Process:
 * Reservoir sampling
 */
package LinkedList;

import java.util.Random;

/**
 *
 * @author xinrong
 */
public class LinkedListRandomNode {

    ListNode head = null;
    Random rand;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        int reservoir = head.val;
        ListNode p = head.next;
        int i = 1;
        while (p != null) {
            int j = rand.nextInt(++i);
            if (j < 1) {
                reservoir = p.val;
            }
            p = p.next;
        }
        return reservoir;
    }

}
