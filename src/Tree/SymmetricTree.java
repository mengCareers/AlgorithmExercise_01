/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 * Thought Process:
each mirror position pair val equal -> symetric
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
        return isMirrorValid(root.left, root.right);
    }

    private boolean isMirrorValid(TreeNode ln, TreeNode rn) {
        if (ln == null && rn == null) {
            return true;
        }
        if (ln == null || rn == null) {
            return false;
        }
        if (ln.val != rn.val) {
            return false;
        }
        return isMirrorValid(ln.left, rn.right) && isMirrorValid(ln.right, rn.left);
    }
}
