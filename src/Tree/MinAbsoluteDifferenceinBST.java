/* 530. Minimum Absolute Difference in BST
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * Thought Process: between adjacent values
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class MinAbsoluteDifferenceinBST {

    int min = Integer.MAX_VALUE;
    Integer pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference(root.left);

        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;

        getMinimumDifference(root.right);

        return min;
    }
}
