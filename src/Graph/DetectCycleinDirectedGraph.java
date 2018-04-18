/*
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
public class DetectCycleinDirectedGraph {

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        List<String> adjsA = new ArrayList<>();
        adjsA.add("b");
        adjsA.add("c");
        graph.put("a", adjsA);
        List<String> adjsB = new ArrayList<>();
        adjsB.add("d");
        graph.put("b", adjsB);
        boolean ans = isAcyclic(graph);
        if (!ans) {
            System.out.println("has cycle");
        } else {
            System.out.println("has no cycle");
        }
    }

    public static boolean isAcyclic(Map<String, List<String>> graph) {
        for (String vertex : graph.keySet()) {
            Set<String> visited = new HashSet<>();
            if (!hasNoBackEdge(graph, vertex, visited)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param graph
     * @return false if contains Back Edge that points to itself or one of its
     * containers
     */
    private static boolean hasNoBackEdge(Map<String, List<String>> graph, String root, Set<String> visited) {
        if (visited.contains(root)) {
            return false;
        }
        visited.add(root);
        if (graph.get(root) != null) {
            for (String adj : graph.get(root)) {
                if (!hasNoBackEdge(graph, adj, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
}
