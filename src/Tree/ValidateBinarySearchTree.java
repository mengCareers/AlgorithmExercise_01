package Tree;


import datastructure.TreeNode;

/*
input : root
output: true if is BST
 * Thought Process:
- How do we define BST?
nodes in its left subtree < it
nodes in its right subtree > it
both subtrees are also BST => recursion
 * Correct:
- How do we think as an input?
a node should > left as well as < right
 */

/**
 *
 * @author xinrong
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
//    public boolean isValidBST(TreeNode root) {
//        if (root == null)
//            return true;
//        if (root.left == null && root.right == null)
//            return true;        
//        if (root.left != null) {
//            if (root.left.val >= root.val)
//                return false;
//        }
//        if (root.right != null) {
//            if (root.right.val <= root.val)
//                return false;
//        }
//        return isValidBST(root.left) && isValidBST(root.right);
//    }    
}
