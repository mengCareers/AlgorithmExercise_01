/*
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) 
            return root;
        TreeNode lres = lowestCommonAncestor(root.left, p, q);
        TreeNode rres = lowestCommonAncestor(root.right, p, q);
        
        if (lres == null)
            return rres;
        if (rres == null)
            return lres;
        return root;
    }   
}
