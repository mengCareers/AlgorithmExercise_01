/* 110. Balanced BT
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Get :
 * we check isBalanced on the fly we getHeight
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class BalancedBT {

    boolean fail;
    
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return !fail;
    }

    private int getHeight(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        int l = getHeight(tn.left);
        int r = getHeight(tn.right);
        if (Math.abs(l - r) > 1) {
            fail = true;
        }
        return 1 + Math.max(l, r);
    }
}
