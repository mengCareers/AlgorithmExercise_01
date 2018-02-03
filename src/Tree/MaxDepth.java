/*
 * Thought Process:
Recursively cal height of left and right subtree of a node and get the bigger + 1

if tree is empty then return 0
else a. get max depth of left subtree recursively
     a. get max depth of right subtree recursively
     b. get maxD of above and add 1 for current node
     d. return maxD
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class MaxDepth {
    Node root;
    int maxDep(Node node) {
        if (node == null) return 0;
        int left = maxDep(node.left);
        int right= maxDep(node.right);
        int max = Math.max(left, right) + 1;
        return max;
    }
    public static void main(String[] args) 
    {
        MaxDepth tree = new MaxDepth();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        System.out.println("Height of tree is : " + 
                                      tree.maxDep(tree.root));
    }
}
