/*
 * Thought Process:
we use merge() to merge lists one by one
we recursively merge() the current list with already flattened list
down pointer is used to link nodes of the flattened list
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class FlattenLinkedList {
    LNode merge(LNode a, LNode b) {
        if (a == null) return b;
        if (b == null) return a;
        LNode result; // smaller of a & b
        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        }
        else {
            result = b;
            result.down = merge(a, b.down);
        }
        return result;
    }
    LNode flatten(LNode root) {
        // Base Case
        if (root == null || root.right == null) return root;
        // recur for list on right
        root.right = flatten(root.right);
        // now merge
        root = merge(root, root.right);
        // return root
        // it will be inturn merged with its left
        return root;
    }
}
