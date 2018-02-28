/*
 * Thought Process:
 * 
 */
package Tree;

import datastructure.TreeNode;

/**
 *
 * @author xinrong
 */
public class BST {

    public datastructure.TreeNode root;

    public BST() {
        root = null;
        createTree();
    }

    private void createTree() {
        datastructure.TreeNode node = new datastructure.TreeNode(52);
        node.left = new datastructure.TreeNode(33);
        node.right = new datastructure.TreeNode(65);
        node.left.left = new datastructure.TreeNode(25);
        node.left.right = new datastructure.TreeNode(39);
        node.right.left = new datastructure.TreeNode(60);
        node.right.right = new datastructure.TreeNode(78);
        root = node;
    }

    private void delete(int data) {
        TreeNode cur = root;
        TreeNode parent = root;
        boolean isLeftChild = false;
        if (cur == null) {
            return;
        }
        while (cur != null && cur.val != data) {
            parent = cur;
            if (data < cur.val) {
                cur = cur.left;
                isLeftChild = true;
            } else {
                cur = cur.right;
                isLeftChild = false;
            }
        }
        if (cur == null) {
            return;
        }
        // if leaf node
        if (cur.left == null && cur.right == null) {
            if (cur == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } // if node to delete has a child
        else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (isLeftChild) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } // if node to delete has a child
        else if (cur.left == null) {
            if (root == null) {
                root = cur.right;
            } else if (isLeftChild) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } // if node to delete has children
        else {
            TreeNode successor = getSuccessor(cur);
            if (cur == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = cur.left;
        }
    }

    
    
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode successorParent = node;
        TreeNode successor = node;
        TreeNode cur = node.right;
        while (cur != null) {
            successorParent = successor;
            successor = cur;
            cur = cur.left;
        }
        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }
    
    public int getSmallest() {
        return getSmallestUtil(root);       
    }
    
    private int getSmallestUtil(TreeNode node) {
        if (node.left == null)
            return node.val;
        return getSmallestUtil(node.left);
    }
    
    
}
