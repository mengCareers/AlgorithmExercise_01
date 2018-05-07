/*
During the pairing process in each round, you always need to follow the strategy of making the rather strong one pair with the rather weak one.
 * Thought Process:
always maximum distance
 * 
 */
package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class OutputContestMatches {

    public String findContestMatch(int n) {
        TreeNode[] matches = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            matches[i] = new TreeNode(i + 1);
        }
        buildMatchTree(matches, n);
        StringBuilder sb = new StringBuilder();
        outputMatch(matches[0], sb);
        return sb.toString();
    }

    /**
     * Utility Method to output contest Matches recursively
     *
     * @param root
     * @param sb
     */
    private void outputMatch(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        sb.append("(");
        outputMatch(root.left, sb);
        sb.append(",");
        outputMatch(root.right, sb);
        sb.append(")");
    }

    /**
     * Utility Method to build recursion tree for pairs of matches.
     *
     * @param matches
     * @param n
     */
    private void buildMatchTree(TreeNode[] matches, int n) {
        int len = n;
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                TreeNode tnode = new TreeNode(matches[i].val);
                tnode.left = matches[i];
                tnode.right = matches[len - 1 - i];
                matches[i] = tnode;
            }
            len = len / 2;
        }
    }

    class TreeNode {

        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String findContestMatchWrong(int n) {
        List<String> contest = new ArrayList<>();
        int min = 1, max = n;
        StringBuilder sb = new StringBuilder();
        String match = "";
        while (min < max) {
            min++;
            max--;
            sb.setLength(0);
            match = sb.append("(").append(min).append(max).append(")").toString();
            contest.add(match);
        }
        return "";
    }
}
