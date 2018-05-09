/*
Input:
        2
       / \
      1   3
Output: 3
Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 * Thought Process:
Tree In-order Serialization, and find longest increasing or decreasing subarray
Then we add Pre-order, but not all of Pre-order is valid.
Why not jump out of the Order Traversal Circle?
* Get :
Longest can be Consecutive Subarray :
the difference between maximum and minimum elements in subarray is equal to the difference between last and first indexes of subarray
That is not the same case with the problem.
We associate two variables named inc, dec to each node,
such that inc represents the length of the longest incrementing branch below the current node (including)
          dec represents the length of the longest decrementing branch below the current node (including)
Recursion, longestPath(node) which returns an array of the form [inc, dec] for the calling node
        left[] = longestPath(node.left); 
        right[] = longestPath(node.right); 
        inc = Math.max(left[0] + 1, right[0] + 1);
        dec = Math.max(left[1] + 1, right[1] + 1);
        return inc + dec - 1;
 * 
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class BinaryTreeLongestConsecutiveSequenceII {

    int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxLen;
    }

    // return new int[]{inc, dec};
    private int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int dec = 1, inc = 1;
        if (root.left != null) {
            int[] left = longestPath(root.left);
            if (root.val == root.left.val + 1) {
                dec = left[1] + 1;
            }
            if (root.val == root.left.val - 1) {
                inc = left[0] + 1;
            }
        }
        if (root.right != null) {
            int[] right = longestPath(root.right);
            if (root.val == root.right.val + 1) {
                dec = Math.max(dec, right[1] + 1);
            }
            if (root.val == root.right.val - 1) {
                inc = Math.max(inc, right[0] + 1);
            }
        }
        maxLen = Math.max(maxLen, inc + dec - 1);
        return new int[]{inc, dec};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeLongestConsecutiveSequenceII inst = new BinaryTreeLongestConsecutiveSequenceII();
        inst.longestConsecutive(root);
    }

    List<Integer> nodeVals;
    List<Integer> nodeVals2;

    public int longestConsecutiveWrong(TreeNode root) {
        nodeVals = new ArrayList<>();
        nodeVals2 = new ArrayList<>();
        inorderSerialization(root);
        preorderSerialization(root);
        int[] vals = listToArray(nodeVals);
        int[] vals2 = listToArray(nodeVals2);

        int maxLen = getLongestIncreasingorDecreasingSubarray(vals);
        int maxLen2 = getLongestIncreasingorDecreasingSubarray(vals2);
        return Math.max(maxLen, maxLen2);
    }

    private int getLongestIncreasingorDecreasingSubarray(int[] vals) {
        int maxLen = 1;
        for (int s = 0; s < vals.length - 1; s++) {
            int min = vals[s], max = vals[s];
            boolean emin = false, emax = false;
            for (int e = s + 1; e < vals.length; e++) {
                if (vals[e] < min) {
                    if (emax) {
                        break;
                    }
                    emin = true;
                    min = vals[e];
                    if (max - min != e - s) {
                        break;
                    }
                    maxLen = Math.max(maxLen, e - s + 1);
                } else if (vals[e] > max) {
                    if (emin) {
                        break;
                    }
                    emax = true;
                    max = vals[e];
                    if (max - min != e - s) {
                        break;
                    }
                    maxLen = Math.max(maxLen, e - s + 1);
                }
            }
        }
        return maxLen;
    }

    private int[] listToArray(List<Integer> nodeVals) {
        int[] vals = new int[nodeVals.size()];
        int vi = 0;
        for (int val : nodeVals) {
            vals[vi++] = val;
        }
        return vals;
    }

    private void inorderSerialization(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderSerialization(root.left);
        nodeVals.add(root.val);
        inorderSerialization(root.right);
    }

    private void preorderSerialization(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeVals2.add(root.val);
        preorderSerialization(root.left);
        preorderSerialization(root.right);
    }
}
