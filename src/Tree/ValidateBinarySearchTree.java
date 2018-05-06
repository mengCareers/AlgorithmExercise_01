package Tree;

import datastructure.TreeNode;

/*
input : root
output: true if is BST
 * Thought Process:
- Why do we use Long.MIN_VALUE, Long.MAX_VALUE ?
- What is exit of the recursion?
 * Correct:
 */
/**
 *
 * @author xinrong
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val <= root.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBSTTrick(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTUtil(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSTUtil(root.left, min, root.val) && isValidBSTUtil(root.right, root.val, max);
    }

}
