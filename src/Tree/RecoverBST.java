/* 99. Recover Binary Search Tree
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
 * Thought Process:
Q : What does 'Recover the tree without changing its structure' mean?
A : we swap the swapped nodes' values only
    we need to set pointers on the swapped nodes in the traversal
 * 
 */
package Tree;

import datastructure.TreeNode;

/**
 *
 * @author xinrong
 */
public class RecoverBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        new RecoverBST().recoverTree(root);
    }

    TreeNode fst = null;
    TreeNode snd = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        int t = fst.val;
        fst.val = snd.val;
        snd.val = t;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        
        if (fst == null && pre.val >= root.val)
            fst = pre;
        if (fst != null && pre.val >= root.val)
            snd = root;
        pre = root;
        
        inorder(root.right);
    }
}
