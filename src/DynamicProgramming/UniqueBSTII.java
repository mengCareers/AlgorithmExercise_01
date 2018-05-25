/* 95.
input : n
output: generate all structurally unique BST's
 * Thought Process:
 * we need a func() to generate the answer
question: generate all structurally unique BST's that stores 1..n
state : dp[i] generate all structurally unique BST's that stores 1..i
aim state : dp[n] 
it is hard to transfer
we take i as root, (1 <= i <= n)
its left will be  (1 .. i-1), its right will be (i+1 .. n)
so dp[s][e] should be ll structurally unique BST's that stores s..e
dp[1][i-1] x dp[i+1][n]
 */
package DynamicProgramming;

import datastructure.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class UniqueBSTII {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int s, int e) {
        List<TreeNode> result = new ArrayList<>();
        if (s > e) {
            result.add(null);
            return result;
        }
        List<TreeNode> leftSub, rightSub;
        for (int r = s; r <= e; r++) {
            leftSub = generateTrees(s, r - 1);
            rightSub = generateTrees(r + 1, e);

            for (TreeNode leftNode : leftSub) {
                for (TreeNode rightNode : rightSub) {
                    TreeNode root = new TreeNode(r);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }

        }
        return result;
    }

}
