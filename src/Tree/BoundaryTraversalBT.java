/* print boundary nodes of BT Anti-clockwise starting from root
 * Thought Process:
 * boundary nodes composed by 
    left boundary [top-down]
    leaf left-right
    right boundary [bottom-up]

 */
package Tree;

import datastructure.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class BoundaryTraversalBT {

    TreeNode root;

    public static void main(String args[]) {
        BoundaryTraversalBT tree = new BoundaryTraversalBT();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.left.right.left = new TreeNode(7);
        tree.root.left.right.right = new TreeNode(8);
        tree.root.right.left.left = new TreeNode(9);
        tree.root.right.left.right = new TreeNode(10);

        tree.boundaryOfBinaryTree(tree.root);
    }

    List<Integer> res;
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        utilleft(root.left);
        /*
        Q : why not utilleaf(root) ?
        A : if does, tree with one node root, will show twice in the result list
        */
        utilleaf(root.left);
        utilleaf(root.right);
        utilright(root.right);
        return res;
    }
    private void utilleft(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                res.add(node.val);
                utilleft(node.left);
            } 
            else if (node.right != null) {
                res.add(node.val);
                utilleft(node.right);
            }
        }
    }
    private void utilright(TreeNode node) {
        if (node != null) {
            if (node.right != null) {
                utilright(node.right);
                res.add(node.val);
                
            }
            else if (node.left != null) {
                utilright(node.left);
                res.add(node.val);
                
            }
        }
    }
    private void utilleaf(TreeNode node) {
        if (node != null) {        
            if (node.left == null && node.right == null)
                res.add(node.val);
            utilleaf(node.left);
            utilleaf(node.right);
        }
    }
}


/* WRONG
    Stack<TreeNode> stack;
    // (x, y) 
    // if leaf 
    // if left side  (x, 0)
    // if right side (0, y)
    public void printparameter() {
        if (root == null) {
            return;
        }

        stack = new Stack<>();
        System.out.print(root.val + ",");
        printparameter(root, 0, 0);
        while (!stack.empty()) {
            System.out.print(stack.pop().val + ",");
        }
    }

    private void printparameter(TreeNode node, int left, int right) {

        if (node != null) {
            if (right == 0 && left != 0) {
                System.out.print(node.val + ",");
            } else if (right != 0 && left == 0) {
                //System.out.print(node.val + ",");
                stack.push(node);
            } else if (node.left == null && node.right == null) {
                System.out.print(node.val + ",");
            }
            printparameter(node.left, left + 1, right);
            printparameter(node.right, left, right + 1);
        }
    }
*/