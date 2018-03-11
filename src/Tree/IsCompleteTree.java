/* true if a tree is complete tree
 * Thought Process:
 * 
 */
package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class IsCompleteTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(10);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        boolean ans = new IsCompleteTree().isCompleteTree(t1);
        System.out.println(ans);
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean meetOneChild = false;
        while (!q.isEmpty()) {
            TreeNode pn = q.poll();
            if (pn.left != null) {
                if (meetOneChild == true) {
                    return false;
                }
                q.add(pn.left);

            }
            else
                meetOneChild = true;
            if (pn.right != null) {
                if (meetOneChild == true) {
                    return false;
                }
                q.add(pn.right);
            }
        }

        return true;
    }
}
