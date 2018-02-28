/* 105. Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.
You may assume that duplicates do not exist in the tree.
For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
* Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class ConstructBTfromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return util(preorder, inorder, 0, 0, inorder.length - 1);
    }    
    TreeNode util(int[] preorder, int[] inorder, int prestart, int s, int e) {
        if (prestart >= preorder.length || s > e)
            return null;
        int rootval = preorder[prestart];
        TreeNode root = new TreeNode(rootval);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == rootval)
                break;
        }
        root.left = util(preorder, inorder, prestart + 1, s, i - 1);
        root.right = util(preorder, inorder, prestart + i - s + 1, i + 1, e);
        return root;
    }
}
