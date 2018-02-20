/*
input : root, L, R
output: trimmed root
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        TreeNode tl = trimBST(root.left, L, R);
        TreeNode tr = trimBST(root.right, L, R);
        root.left = tl;
        root.right = tr;
        return root;
    }
}
