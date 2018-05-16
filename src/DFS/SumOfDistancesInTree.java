/* 834. Sum of Distances in Tree
input : N nodes labelled 0 .. N - 1
        N edges, ith edge connects nodes edges[i][0] and edges[i][1] together
output: int[] ans, where ans[i] is the sum of the distances between node i and all other nodes
Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: 
Here is a diagram of the given tree:
  0
 / \
1   2
   /|\
  3 4 5
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 * Thought Process:
DFS, we need to now :
start : Nth node
Standing at start, how many choices do I have ?
    
end : reach all nodes
 * Instruct :
I cannot do think it of in a DFS way, let's do it Brute Force
Treat each Node as root and do traversal to get the sum of distances one by one
At least, you should represent the tree graph first.
 */
package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class SumOfDistancesInTree {

    int[] result, cntSub;
    List<Set<Integer>> tree;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        result = new int[N];
        cntSub = new int[N];
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        recursionUtil(0, new HashSet<>());
        recursionUtil2(0, new HashSet<>(), N);
        return result;
    }

    private void recursionUtil(int root, Set<Integer> visited) {
        visited.add(root);
        for (int child : tree.get(root)) {
            if (!visited.contains(child)) {
                recursionUtil(child, visited);
                cntSub[root] += cntSub[child];
                result[root] += result[child] + cntSub[child];
            }
        }
        cntSub[root]++;
    }

    private void recursionUtil2(int root, Set<Integer> visited, int N) {
        visited.add(root);
        for (int child : tree.get(root)) {
            if (!visited.contains(child)) {
                result[child] = result[root] - cntSub[child] + N - cntSub[child];
                recursionUtil2(child, visited, N);
            }
        }
    }

    /*
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = sumOfDistancesInTreeFrom(i, N, edges, 1, new DistanceSum());
        }
        return result;
    }

    
    
    private int sumOfDistancesInTreeFrom(int cur, int N, int[][] edges, int nodesReached, DistanceSum sum) {
        if (nodesReached == N - 1) {
            return sum.val;
        }
        for (int i = 0; i < N; i++) {
            if (cur != i) {
                sum.val += getDistance(cur, i) + sumOfDistancesInTreeFrom(i, N, edges, nodesReached, sum);
            }
        }
    }
    
    private int getDistance(int cur, int i) {
        
    }
    
    class DistanceSum {
        int val;
    }
     */
}
