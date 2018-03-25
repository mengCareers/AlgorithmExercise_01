/*
input : n nodes labeled from 0 to n - 1
        list of undirected edges
output: true if make up a valid tree
 * Thought Process:
how ? no circle
      topological
 * 
 */
package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class GraphValidTree {

    public static void main(String[] args) {
        int n = 4;

        int[][] edges = {{0, 1}, {2, 3}};
        boolean ans = new GraphValidTree().validTree(n, edges);
        System.out.println(ans);
    }

    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            if (visited[tmp]) {
                return false; // cycle
            }
            visited[tmp] = true;
            for (int tadj : graph.get(tmp)) {
                queue.add(tadj);
                graph.get(tadj).remove((Object) tmp);
            }
        }
        for (boolean vi : visited) {
            if (!vi) {
                return false;
            }
        }
        return true;
    }
}
