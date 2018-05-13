/* 783. Minimum Distance Between BST Nodes
Given a Binary Search Tree (BST) with the root node root, 
return the minimum difference between the values of any two different nodes in the tree.
 * Thought Process:
 * Recursion or Serialization (is also recursion)
 * Get:
BST Inorder Traversal will output values in order.
During the traversal, 
we calculate the difference between current node value with its previous value and keep track of the minDist on the fly.
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class MinimumDistanceBetweenBSTNodes {

    Integer prev;
    int minDist;

    public int minDiffInBST(TreeNode root) {
        prev = null;
        minDist = Integer.MAX_VALUE;
        inorder(root);
        return minDist;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        if (prev != null) {
            minDist = Math.min(minDist, root.val - prev);
        }
        prev = root.val;

        inorder(root.right);
    }
}
