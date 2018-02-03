package Tree;


import Tree.Node;

/*
337. House Robber III
all houses formed a bt, to avoid two directly linked houses robbed in the same night
 * Thought Process:
to avoid adjacent levels together, 
we cal sum for each level (BFS), and add no adjacent to get maximum
e.g. 
  3         3
2   3       5
 3   1      4
max(7, 5) = 7
 * 
 */

/**
 *
 * @author xinrong
 */
public class HouseRobberIII {
    public int rob(Node root) {
        if (root == null)
            return 0;
        return Math.max(robInclude(root), robExclude(root));
    }    
    private int robInclude(Node node) {
        if (node == null)
            return 0;
        return node.val + robExclude(node.left) + robExclude(node.right);
    }
    private int robExclude(Node node) {
        if (node == null)
            return 0;
        return rob(node.left) + rob(node.right);
    }
}
