/*  
617. Merge Two Binary Trees
Merge rule: if overlap, sum node vals up as the new val
 * Thought Process:
 * recursion merge into t1
   t1.val = ?      A: {t1.val + t2.val}
   t1.left.val = ? A: t1.left.val + t2.left.val
   t1.right.val= ? A: t1.right.val + t2.right.val
   if {} is a func, recursively call it
   exit when t1 == null || t2 == null
 */
package Tree;

import datastructure.TreeNode;

/**
 *
 * @author xinrong
 */
public class Merge2BT {  
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t2.right= mergeTrees(t1.right, t2.right);
        return t1;
    }
}
