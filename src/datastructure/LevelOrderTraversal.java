
import datastructure.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * input: TreeNode root
 * output:List<Integer> res
 * @author xinrong
 */
public class LevelOrderTraversal {
    // Recursion  
    List<Integer> result = new ArrayList<>();
    public List<Integer> printLevelOrderRecursion(TreeNode root) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printGivenLvl(root, i);
        }
        return result;
    }
    private void printGivenLvl(TreeNode root, int lvl) {
        if (root == null) return;
        if (lvl == 1) result.add(root.val);
        else if (lvl > 1) {
            printGivenLvl(root.left, lvl - 1);
            printGivenLvl(root.right, lvl - 1);
        }
    }
    private int height(TreeNode root) {
        if (root == null) return 0;
        else {
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }
    }

    // Using Q
    public List<Integer> printLevelOrderUsingQ(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode tmp = q.poll();
            res.add(tmp.val);
            if (tmp.left != null) q.add(tmp.left);
            if (tmp.right != null) q.add(tmp.right);
        } 
        return res;
    }
    
    public static void main(String[] args) {  
        TreeNode root = new TreeNode(1);     
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        TreeNode r2 = new TreeNode(7);
        r1.right = r2;
        // Recursion
        System.out.println("Recursion: ");
        List<Integer> answer = new LevelOrderTraversal().printLevelOrderRecursion(root);
        for (int ans : answer) {
            System.out.println(ans);
        }
        System.out.println("Using Q: ");
        // using Q
        List<Integer> res = new LevelOrderTraversal().printLevelOrderUsingQ(root);
        for (int i : res) {
            System.out.println(i);
        }
        
    }
}
