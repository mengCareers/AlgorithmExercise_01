/*
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */

class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }
    
}

public class TreeHw {

    public TreeNode root;

    public TreeHw() {
        root = null;
        createTree();
    }

    private void createTree() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);
        node.left.right.right = new TreeNode(10);
        node.right.right.right = new TreeNode(11);
        root = node;
    }
    
    int res;
    
    /**
     * Method to Find Level of a Node in Binary Tree
     * @param target The aim node's value.
     * @return Level of the aim node. Or -1 if not found.
     */
    public int findDataLevel(int target) {    
        res = Integer.MAX_VALUE;
        findDataLevelUtil(root, 1, target);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * Util Method to Find Level of a Node
     * @param node The current node.
     * @param lvl The level of the current node.
     * @param target The data we aim to find.
     */
    private void findDataLevelUtil(TreeNode node, int lvl, int target) {
        
        if (node != null) {

            if (node.val == target) {
                res = lvl;
                return;
            }

            findDataLevelUtil(node.left, lvl + 1, target);
            findDataLevelUtil(node.right, lvl + 1, target);
            
        }

    }

    public static void main(String[] args) {
        TreeHw t = new TreeHw();
        
        int ans = 0;
        
        // For node doesn't exist
        ans = t.findDataLevel(12);
        System.out.println("The aim node is in level : " + ans);
        
        // For nodes exist
        for (int i = 1; i <= 11; i++) {
            ans = t.findDataLevel(i);
            System.out.println("The aim node is in level : " + ans);
        }
        
    }
}
