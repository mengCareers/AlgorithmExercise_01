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
 *
 * @author xinrong
 */
public class VerticalSuminBinaryTree {
    public List<Integer> verticalSumBT(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> colq = new LinkedList<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        q.add(root);
        colq.add(0);
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            int col = colq.poll();
            if (!map.containsKey(col)) 
                map.put(col, new ArrayList<TreeNode>()); 
            map.get(col).add(temp);
            if (temp.left != null) {
                q.add(temp.left);
                colq.add(col - 1);
                min = Math.min(min, col - 1);
            }
            if (temp.right!= null) {
                q.add(temp.right);
                colq.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            List<TreeNode> list = map.get(i);
            int sum = 0;
            for (TreeNode tn : list) {
                sum += tn.val;
            }
            result.add(sum);
        }
        return result;
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
        System.out.println("Vertical Order Sum of BT is");
        List<Integer> ans = new VerticalSuminBinaryTree().verticalSumBT(root);
        for (int i : ans) System.out.println(i);
    }
}
