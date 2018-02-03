package Tree;

import datastructure.TreeNode;


/*
 *  Q:226. Invert Binary Tree
 *  Get:
TP: The inverse of empty tree 
            is empty,
        inverse of a tree with root r, and subright and subleft, 
            is a tree with root r, and subright is the inverse of subleft, vice versa.. 
 */

/**
 *
 * @author xinrong
 */
public class InvertBT {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        
        TreeNode rn = invertTree(root.left);
        TreeNode ln = invertTree(root.right);
        root.right = rn;
        root.left  = ln;
        return root;
    }
}
