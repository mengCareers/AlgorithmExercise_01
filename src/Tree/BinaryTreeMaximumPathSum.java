/* 124.Binary Tree Maximum Path Sum
Given a binary tree, find the maximum path sum.
For this problem, 
a path is defined as any sequence of nodes 
    from some starting node to any node in the tree along the parent-child connections. 
    The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * Thought Process :
in-order traversal
get the max on the fly
 * Get : 
getMaxPath:
    if left path > right path,
    return left path + cur.val
    (recursion to the node)
on the fly, keep track of maxpathsum
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
    private int maxPath(TreeNode root) {
        if (root == null)
            return 0;
            
        int left = Math.max(0, maxPath(root.left));
        int right= Math.max(0, maxPath(root.right));
        max = Math.max(max, left + root.val + right);
        
        int sum = 0;        
        if (left > right) {
            sum = left + root.val;
            
        }
        else {
            sum = right + root.val;
        }
        return sum;
    }
}
