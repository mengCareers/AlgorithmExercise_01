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
        return construct(nums, 0, nums.length);
    }
    TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int mi = getMaxI(nums, l, r);
        TreeNode root = new TreeNode(nums[mi]);
        root.left = construct(nums, l, mi);
        root.right = construct(nums, mi + 1, r);
        return root;
    }
    int getMaxI(int[] nums, int l, int r) {
        int mi = l;
        int mv = nums[l];
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > mv) {
                mi = i;
                mv = nums[i];
            }
        }
        return mi;
    }
}
