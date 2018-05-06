/*
There are 3 cases:
No loop, but there is one node who has 2 parents.
A loop, and there is one node who has 2 parents, that node must be inside the loop.
A loop, and every node has only 1 parent.
 * Thought Process:
 * 
 */
package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class RedundantConnectionII {

    public static void main(String[] args) {
        int[][] edges = {{6, 3}, {8, 4}, {9, 6}, {3, 2}, {5, 10}, {10, 7}, {2, 1}, {7, 6}, {4, 5}, {1, 8}};
        int[] res = findRedundantDirectedConnection(edges);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();// v's children
        Map<Integer, List<Integer>> parentMap = new HashMap<>(); // v's parents

        int vertexWithParents = -1;
        int[] vertexWithParentsLatterEdge = null;

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if (!childrenMap.containsKey(from)) {
                childrenMap.put(from, new ArrayList<>());
            }
            childrenMap.get(from).add(to);

            if (!parentMap.containsKey(to)) {
                parentMap.put(to, new ArrayList<>());
            } else {
                vertexWithParents = to;
                vertexWithParentsLatterEdge = edges[i];
            }
            parentMap.get(to).add(from);
        }

        List<Integer> cyclePath = isCyclic(childrenMap);

        // with only cyclic issue
        if (vertexWithParents == -1) {
            return new int[]{cyclePath.get(cyclePath.size() - 2), cyclePath.get(cyclePath.size() - 1)};
        }

        // with cyclic issue and two-parents issue
        if (cyclePath != null) {
            int cycleStartPoint = cyclePath.get(cyclePath.size() - 1);
            while (cyclePath.get(0) != cycleStartPoint) {
                cyclePath.remove(0);
            }
            List<Integer> parents = parentMap.get(vertexWithParents);
            for (int parent : parents) {
                if (cyclePath.contains(parent)) {
                    return new int[]{parent, vertexWithParents};
                }
            }
        }

        // with only two-parents issue
        return vertexWithParentsLatterEdge;
    }

    /**
     * To check if the graph is cyclic
     *
     * @param childrenMap
     * @return list of vertices passed while detecting the cycle if the graph is
     * cyclic, null if the graph is acyclic
     */
    private static List<Integer> isCyclic(Map<Integer, List<Integer>> childrenMap) {
        boolean isCyclic = false;
        List<Integer> cyclePath = null;
        for (int k : childrenMap.keySet()) {
            Set<Integer> visited = new HashSet<>();
            List<Integer> tmpCyclePath = new ArrayList<>();
            if (!hasNoBackEdge(childrenMap, k, visited, tmpCyclePath)) {
                cyclePath = tmpCyclePath;
                isCyclic = true;
                break;
            }
        }
        if (isCyclic) {
            return cyclePath;
        }
        return null;
    }

    /**
     * To check if the graph starting at the root vertex is cyclic
     *
     * @param graph
     * @param root the starting vertex
     * @param visited set of vertices visited
     * @param cycle list of vertices passed to detect the cycle
     * @return true if without back edges, i.e., graph is acyclic
     */
    private static boolean hasNoBackEdge(Map<Integer, List<Integer>> graph, int root, Set<Integer> visited, List<Integer> cycle) {
        if (visited.contains(root)) {
            cycle.add(root);
            return false;
        }
        visited.add(root);
        cycle.add(root);
        if (graph.get(root) != null) {
            for (int adj : graph.get(root)) {
                if (!hasNoBackEdge(graph, adj, visited, cycle)) {
                    return false;
                }
            }
        }
        cycle.remove(cycle.size() - 1);
        visited.remove(root);
        return true;
    }

}
