/*
root is maximum
recursively
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int maxid = getMax(nums, s, e);
        TreeNode root = new TreeNode(nums[maxid]);
        root.left = constructMaximumBinaryTree(nums, s, maxid - 1);
        root.right = constructMaximumBinaryTree(nums, maxid + 1, e);
        return root;
    }

    private int getMax(int[] nums, int s, int e) { // [s, e]
        int maxid = s;
        for (int i = s; i <= e; i++) {
            if (nums[i] > nums[maxid]) {
                maxid = i;
            }
        }
        return maxid;
    }
}
