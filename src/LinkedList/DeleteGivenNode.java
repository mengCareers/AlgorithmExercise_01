/*
 * Thought Process:
 * No access to the node before the one to delete, so we have to replace value of the one to delete 
 * with the value in 'the node after it' and then delete 'the node after it'
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class DeleteGivenNode {
    public void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
