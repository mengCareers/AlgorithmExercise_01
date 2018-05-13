/*
Given a BST with duplicates, 
find all the modes (the most frequently occured element)
in the given BST
Assume a BST is defined as follows:
the left subtree contains only nodes with keys <= node's key
the right subtree contains only nodes with keys >= node's key
Both the left and the right subtrees must also be BST
 * Thought Process:
 * in order traversal
 */
package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class FindModeinBST {

    Map<Integer, Integer> valToFreq;

    public int[] findMode(TreeNode root) {
        valToFreq = new HashMap<>();
        inorder(root);
        int maxFreq = 0;

        for (int k : valToFreq.keySet()) {
            if (valToFreq.get(k) > maxFreq) {
                maxFreq = valToFreq.get(k);
            }
        }
        List<Integer> modeList = new ArrayList<>();
        for (int k : valToFreq.keySet()) {
            if (valToFreq.get(k) == maxFreq) {
                modeList.add(k);
            }
        }
        int[] modes = new int[modeList.size()];
        int mi = 0;
        for (int m : modeList) {
            modes[mi++] = m;
        }
        return modes;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        valToFreq.put(root.val, valToFreq.getOrDefault(root.val, 0) + 1);
        inorder(root.right);
    }
}
