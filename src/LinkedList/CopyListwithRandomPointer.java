/*138. Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
 * Thought Process:
what is deep copy : value and pointer copy
1 -> 2 -> 3 -> N
 * GET:
There are 3 steps :
=> insert new nodes int the following pattern and copy values :
from 1->2->N to 1->1->2->2->3->3->N
=> copy random pointers
=> separate copies from originals
 * 
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class CopyListwithRandomPointer {

    class RandomListNode {

        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        RandomListNode ptr = head;
        while (ptr != null) {
            RandomListNode copy = new RandomListNode(ptr.label);
            copy.next = ptr.next;
            ptr.next = copy;
            copy.random = ptr.random.next;
            ptr = ptr.next.next;
        }
        RandomListNode newhead = head.next;
        ptr = head;
        while (ptr != null) {
            ptr.next = ptr.next.next;
            ptr = ptr.next;
        }
        return newhead;
    }
}
