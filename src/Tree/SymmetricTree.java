/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 * Thought Process:
if root is symmetric <- issymutil(root.left, root.right)
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return issymutil(root.left, root.right);
    }

    private boolean issymutil(TreeNode ln, TreeNode rn) {
        if (ln == null && rn == null) {
            return true;
        }
        if (ln == null || rn == null) {
            return false;
        }
        if (ln.val != rn.val) {
            return false;
        }
        return issymutil(ln.left, rn.right) && issymutil(ln.right, rn.left);
    }
}
