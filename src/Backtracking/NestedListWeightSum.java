package Backtracking;


import java.util.List;

/* Q : 339. Nested List Weight Sum
input : nestedList
output: sum (num * depth)
e.g.  [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * Thought Process:
How do we cal depth? To form a tree, sum(node.val * lvl)
 * Get:
Since the input is nested, we think about recursion.
We don't need to form a tree to use DFS
We loop through the list, and keep track of depth.
- What may we encounter?
If int n, n * d
If list, calculate the sum of the list recursively with depth d + 1.
 * 
 */

/**
 *
 * @author xinrong
 */
public class NestedListWeightSum { 
    /*
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumUtil(nestedList, 1);
    }   
    
    public int depthSumUtil(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger())
                sum += n.getInteger() * depth;
            else
                sum += depthSumUtil(n.getList(), depth + 1);
        }
        return sum;
    }
    */
}

