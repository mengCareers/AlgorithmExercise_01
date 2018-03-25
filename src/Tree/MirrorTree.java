package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class MirrorTree {

    /**
     * Find if two trees are a mirror
     *
     * @param t1 The root of the first tree
     * @param t2 The root of the second tree
     * @return True if two trees are a mirror
     */
    public boolean areMirrorTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return areMirrorTrees(t1.left, t2.right) && areMirrorTrees(t1.right, t2.left);
    }

    /**
     * Find if a tree has two nodes which are a mirror Thought Process : For
     * each node pnode, check its corresponding mirror position. If there is a
     * node mnode in the mirror position, and their values are equal, return
     * true
     *
     * @param root The root of the tree
     * @return True if the tree has two nodes which are a mirror
     */
    public boolean hasMirrorNodes(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode pnode = q.poll();
            TreeNode mnode = findMirrorUtil(pnode, root.left, root.right);
            if (mnode != null && mnode.val == pnode.val) {
                return true;
            }
            if (pnode.left != null) {
                q.add(pnode.left);
            }
            if (pnode.right != null) {
                q.add(pnode.right);
            }
        }
        return false;
    }

    /**
     * Util method to check a node's corresponding mirror position
     *
     * @param node
     * @param left
     * @param right
     * @return The node at its mirror position, or null if there is no node.
     */
    private TreeNode findMirrorUtil(TreeNode node, TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return null;
        }
        if (left.val == node.val) {
            return right;
        }
        if (right.val == node.val) {
            return left;
        }
        TreeNode tnode = findMirrorUtil(node, left.left, right.right);
        if (tnode != null) {
            return tnode;
        }
        return findMirrorUtil(node, left.right, right.left);
    }

    /**
     * Find if a tree (with root subt) is a sub-tree of another
     *
     * @param subt The root of the subtree
     * @param t The root of the other tree
     * @return True if the tree (with root subt) is a sub-tree of another
     */
    public boolean isSubtree(TreeNode subt, TreeNode t) {
        if (subt == null) {
            return true;
        }
        if (t == null) {
            return false;
        }
        if (areEqualUtil(subt, t)) {
            return true;
        }
        return isSubtree(subt, t.left) || isSubtree(subt, t.right);
    }

    /**
     * Util method to check if two trees are identical
     *
     * @param t1 The root of one tree
     * @param t2 The root of the other tree
     * @return True if two trees are identical
     */
    private boolean areEqualUtil(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return areEqualUtil(t1.left, t2.left) && areEqualUtil(t1.right, t2.right);
    }

    static class TreeNode {

        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

}
