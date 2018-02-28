/* 104. Maximum Depth of Binary Tree
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
