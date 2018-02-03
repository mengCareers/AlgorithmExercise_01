/* print boundary nodes of BT Anti-clockwise starting from root
 * Thought Process:
 * boundary nodes composed by 
    left boundary top-down
    leaf left-right
    right boundary bottom-up
attention: leftmost node is both left boundary & leaf
 */
package Tree;

import datastructure.TreeNode;

/**
 *
 * @author xinrong
 */
public class BoundaryTraversalBT {
    TreeNode root;
    
    public static void main(String args[]) 
    {
        BoundaryTraversalBT tree = new BoundaryTraversalBT();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        tree.root.right = new TreeNode(22);
        tree.root.right.right = new TreeNode(25);
        tree.printBoundaries(tree.root); 
    }
    
    void printBoundaries(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            printBoundaryLeft(node.left);
            printBoundaryLeaf(node.left);
            printBoundaryLeaf(node.right);
            printBoundaryRight(node.right);
        }
    }
    
    void printBoundaryLeaf(TreeNode node) {
        if (node != null) {
            printBoundaryLeaf(node.left);
            if (node.left == null && node.right == null) 
                System.out.print(node.val + " ");
            printBoundaryLeaf(node.right);
        }
    }
    void printBoundaryLeft(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                System.out.print(node.val + " ");
                printBoundaryLeft(node.left);
            } 
            else if (node.right != null) {
                System.out.print(node.val + " ");
                printBoundaryLeft(node.right);
            }
            // do nothing if leaf
        }
    }
    void printBoundaryRight(TreeNode node) {
        if (node != null) {
            if (node.right != null) {
                printBoundaryRight(node.right);
                System.out.print(node.val + " ");
            } 
            else if (node.left != null) {
                printBoundaryRight(node.left);
                System.out.print(node.val + " ");
            }
            // do nothing if leaf
        }
    }
}
