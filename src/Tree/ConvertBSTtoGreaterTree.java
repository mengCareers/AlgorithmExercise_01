/* 538. Convert BST to Greater Tree
 * Thought Process:
 * iterate through BST, for each node, get sum of all keys greater the original key
   node.val += sum;
Get:
to upgrade: 
traverse the nodes in descending order => reverse inorder
keep track of running sum of all nodes traversed thus far
 */
package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class ConvertBSTtoGreaterTree {

    public TreeNode convertBSTUpgrade(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorderReverse(root);
        return root;
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> nodes = getNodes(root);
        Collections.sort(nodes, (TreeNode a, TreeNode b) -> (b.val - a.val));
//        int[] map = new int[nodes.get(0).val + 1]; 
//        What if node.val < 0 ?
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(nodes.get(0).val, 0);
        for (int i = 0; i < nodes.size() - 1; i++) {
            sum += nodes.get(i).val;
            map.put(nodes.get(i + 1).val, sum);
        }
        assignNodes(root, map);
        return root;
    }

    private void inorderReverse(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int sum = 0;
        TreeNode node = root.right;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();

            int nodeval = node.val;
            node.val += sum;
            sum += nodeval;
            node = node.left;
        }

    }

    private void assignNodes(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        assignNodes(node.left, map);
        node.val += map.get(node.val);
        assignNodes(node.right, map);
    }

    private List<TreeNode> getNodes(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode node = root.left;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            nodes.add(node);

            node = node.right;
        }
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(13);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
//        t3.left = t4;
//        t3.right = t7;
//        t4.right = t5;
//        t5.left = t6;
        ConvertBSTtoGreaterTree inst = new ConvertBSTtoGreaterTree();
        TreeNode root = inst.convertBST(t1);
        List<TreeNode> nodes = inst.getNodes(root);
        for (TreeNode tn : nodes) {
            System.out.print(tn.val + " ");
        }
    }
}
