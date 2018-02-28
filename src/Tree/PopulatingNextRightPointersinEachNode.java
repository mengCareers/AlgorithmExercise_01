/* 116. Populating Next Right Pointers in Each Node
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
e.g.
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * Thought Process:
level order traversal
1 N 
2 3 N 
4 5 6 7 N
 * 
 */
package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class PopulatingNextRightPointersinEachNode {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Queue<TreeLinkNode> sq = new LinkedList<>();
        sq.add(root);
        while (!q.isEmpty()) {
            TreeLinkNode p = q.poll();
            if (p != null) {
                sq.add(p);
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            } else {
                while (!sq.isEmpty()) {
                    TreeLinkNode sp = sq.poll();
                    if (!sq.isEmpty()) {
                        sp.next = sq.peek();
                    } else {
                        sp.next = null;
                    }
                }
                if (q.isEmpty()) {
                    return;
                }
                q.add(null);
            }
        }
    }

    class TreeLinkNode {

        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }
}
