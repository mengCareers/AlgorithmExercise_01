/* 310. Minimum Height Trees
Topological Sort in Undirected Graph,
we keep removing the node whoes indegree is 1, that is, the leaf node.
We update minHeightTrees in each level,
the last one remained will be the list containing roots.
 * Thought Process:
 * 
 */
package Graph.Topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if (edges.length == 0) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }

        List<List<Integer>> outList = new ArrayList<>();
        int[] inDeg = new int[n];

        for (int i = 0; i < n; i++) {
            outList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            outList.get(edge[0]).add(edge[1]);
            outList.get(edge[1]).add(edge[0]);
            inDeg[edge[1]]++;
            inDeg[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 1) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int sz = q.size();
            minHeightTrees = new ArrayList<>();
            for (int si = 0; si < sz; si++) {
                int tmp = q.poll();
                minHeightTrees.add(tmp);
                inDeg[tmp]--;
                for (int adjacent : outList.get(tmp)) {
                    inDeg[adjacent]--;
                    if (inDeg[adjacent] == 1) {
                        q.add(adjacent);
                    }
                }

            }
        }
        return minHeightTrees;
    }
}
