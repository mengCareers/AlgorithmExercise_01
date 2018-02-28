/*108.ConvertSortedArrtoBST
Given the sorted array: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
      0
     / \
   -3   9
   /   /
 -10  5
 * Get:
BST - BinarySearch, the root value should be in the middle of 0, len - 1 in the sorted arr
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class ConvertSortedArrtoBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructParent(nums, 0, nums.length - 1); // end is len - 1 not len!!!
    }

    private TreeNode constructParent(int[] nums, int s, int e) {
        if (s > e) { // > not <
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructParent(nums, s, mid - 1);
        node.right = constructParent(nums, mid + 1, e);
        return node;
    }
}
