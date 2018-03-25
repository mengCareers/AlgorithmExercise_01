/* 230. Kth Smallest Element in a BST
 * Thought Process:
 * inorder[k - 1]
        6
     4      8
    2 5    7  9
stack 
res   2 4 5 6 7 8 9
 */
package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class KthSmallestElementinaBST {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        new KthSmallestElementinaBST().kthSmallest(root, 2);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.empty()) {
            node = stack.pop();
            res.add(node.val);
            if (k == res.size()) {
                return res.get(k - 1);
            }
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return Integer.MIN_VALUE;
    }
}
