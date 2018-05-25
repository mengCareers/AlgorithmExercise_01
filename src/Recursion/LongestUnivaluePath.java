/* 687.Longest Univalue Path
input : bt
output: length of the longest path where each node in the path has the same value
 * Thought Process:
 * 'may or may not pass through the root'
if pass throught the root, len = left + right
else, len = left until common parent + right until common parent
 * Longest Path of a tree = max(Longest Path across a node)
 * Longest Path across a node = Left Longest Path start at a node + Right Longest Path start at a node;
recursion relation :
longest path of a tree = max (longest path across a node)
longest path across a node = left longest path start at a node + right longest path start at a node
 */
package Recursion;

import datastructure.TreeNode;

/**
 *
 * @author xinrong
 */
public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int noPassRoot = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        int passRoot = longestUnivalueStartAt(root.val, root.left) + longestUnivalueStartAt(root.val, root.right);
        return Math.max(noPassRoot, passRoot);
    }

    private int longestUnivalueStartAt(int valToCompare, TreeNode node) {
        if (node == null || node.val != valToCompare) {
            return 0;
        }
        return 1 + Math.max(longestUnivalueStartAt(node.val, node.left), longestUnivalueStartAt(node.val, node.right));
    }
}
