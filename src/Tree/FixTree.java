/*
Consider a binary tree, where an arbitary node has 2 parents i.e two nodes in the tree have the same child.
Identify the defective node with 2 parents.
Correct such a node and restore the binary tree properties to that node.
 * Thought Process:
We simply iterate the tree DFS, if visiting already visited, it is ruined here
simple remove it
 * 
 */
package Tree;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class FixTree {

    public static void fixTree(TreeNode root) {
        //fixTreeHelper(root);
        fixTreeHelper(root, null);
    }
    static Set<TreeNode> visited = new HashSet<>();

    // top - down approach
    // similar to backtracking
    // have no parent state
    // Top-down Approach seems more natural, however, we need to keep parent's state.
    private static void fixTreeHelper(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (!visited.contains(node)) {
            visited.add(node);
            fixTreeHelper(node.left, node);
            fixTreeHelper(node.right, node);
        } else {
            if (parent.left == node) {
                parent.left = null;
            } else if (parent.right == node) {
                parent.right = null;
            }
        }
    }

    // bottom - up approach helps us keep root and children at the same recursive level
    private static TreeNode fixTreeHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = fixTreeHelper(root.left);
        TreeNode right = fixTreeHelper(root.right);
        if (left != null) {
            if (visited.contains(left)) {
                root.left = null;
            } else {
                visited.add(left);
            }
        }
        if (right != null) {
            if (visited.contains(right)) {
                root.right = null;
            } else {
                visited.add(right);
            }
        }
        return root;
    }
}
