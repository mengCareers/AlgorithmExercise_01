/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;
import datastructure.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/**
 * Q: What's the same character do nodes in a vertical line share?
 * A: They share the same 'Horizontal Distance' to root
 * Q: How to calculate HD 
 * A: HD for root is 0, a right edge is +1. 
 * Q: Using BFS, why not DFS? Like preorder?
 * A: Preorder can't make sure the appearing order of nodes in a line.
 * Q: How do we use hashmap?
 * A: For every HD value we maintain a list of nodes in hash map
 * to print it.
 * @author xinrong
 */
public class PrintBinaryTreeinVerticalOrder {
    public void printBTVertical(TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>(); // col - nodes
        Queue<Integer> colq = new LinkedList<>(); // cols
        Queue<TreeNode> q = new LinkedList<>(); // nodes
        q.add(root);
        colq.add(0);
        int min = 0, max = 0; // keys of map are consecutive [min, max]
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            int hd = colq.poll(); // horizontal distance from root
            if (!map.containsKey(hd)) map.put(hd, new ArrayList<TreeNode>());
            map.get(hd).add(temp);
            if (temp.left != null) {
                q.add(temp.left);
                colq.add(hd - 1);
                min = Math.min(min, hd - 1);
            }
            if (temp.right!= null) {
                q.add(temp.right);
                colq.add(hd + 1);
                max = Math.max(max, hd + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> list = map.get(i);
            for (TreeNode t : list) {
                System.out.print(t.val + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        System.out.println("Vertical Order traversal is");
        new PrintBinaryTreeinVerticalOrder().printBTVertical(root);
    }
}


