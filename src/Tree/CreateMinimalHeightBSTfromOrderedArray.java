/*
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
public class CreateMinimalHeightBSTfromOrderedArray {
    public TreeNode buildBST(int[] arr) {
        return buildBSTUtil(arr, 0, arr.length - 1);
    }
    
    private TreeNode buildBSTUtil(int[] arr, int s, int e) {
        if (e < s)
            return null;
        int mid = (s + e) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBSTUtil(arr, s, mid - 1);
        root.right= buildBSTUtil(arr, mid + 1, e);
        return root;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2, 3, 4, 5, 6, 7, 8};
        CreateMinimalHeightBSTfromOrderedArray inst = new CreateMinimalHeightBSTfromOrderedArray();
        TreeNode root = inst.buildBST(arr);
        // System.out.println(inst.getDepth(root));
        inst.printEachLayerofTree(root);
    }
    
    private int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
    
    private void printEachLayerofTree(TreeNode node) {
        if (node == null)
            return;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(node);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode tn = q.poll();
            if (tn != null) {
                System.out.print(tn.val + " ");
                if (tn.left != null)
                    q.add(tn.left);
                if (tn.right != null)
                    q.add(tn.right);
            } 
            else {
                System.out.println();
                if (q.isEmpty())
                    return;
                q.add(null);
            }
        }
        
    }
}
