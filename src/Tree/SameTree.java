package Tree;


import datastructure.TreeNode;

/* 
input: p, q
output:true if 2 trees are the same
 * Thought Process:
- How to define 2 trees are 'same'?
structure same, val same

 * 
 */

/**
 *
 * @author xinrong
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
