/*
 * Thought Process:
 * 
 */
package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class AverageofLevelsinBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int lvlnum = q.size();
            double lvlsum = 0;
            for (int i = 0; i < lvlnum; i++) {
                TreeNode pnode = q.poll();
                lvlsum += pnode.val;
                if (pnode.left != null) {
                    q.add(pnode.left);
                }
                if (pnode.right != null) {
                    q.add(pnode.right);
                }
            }
            res.add(lvlsum / lvlnum);
        }
        return res;
    }
}
