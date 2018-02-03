package Tree;


import datastructure.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 199	Binary Tree Right Side View
 *  Q: 
    input: root
    output: List of vals of rightmost nodes of each level from root to bottom
 *  Get:
    last nodes of each level -> lvl order trversal
 */

/**
 *
 * @author xinrong
 */
public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);     
        while (!q.isEmpty()){
            int lvlsz = q.size();
            for (int i = 0; i < lvlsz; i++) {
                TreeNode t = q.poll();
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
                if (i == lvlsz - 1)
                    res.add(t.val);
            }
        }
        
        return res;
    }
}
