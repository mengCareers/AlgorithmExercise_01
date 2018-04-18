/*
WHAT ?
Given a graph and a source vertex src in graph, find shortest paths from src to all vertices in the given graph. The graph may contain negative weight edges.
Q ?
Input: Graph and a source vertex src
Output: Shortest distance to all vertices from src. If there is a negative weight cycle, then shortest distances are not calculated, negative weight cycle is reported.
* Thought Process:
 * 
 */
package Graph.ShortestPath;

/**
 *
 * @author xinrong
 */
public class BellmanFord {

    public static void main(String[] args) {

    }

    static final int V = 9; // # of vertices
    static final int E = 10;

    public static void singleSrcShortestPath(int[][] graph, int src, int[][] edge) {
        int[] shortestDist = new int[V]; // shortestDist[i] is shortestDist from src to i
        for (int i = 0; i < V; i++) {
            shortestDist[i] = Integer.MAX_VALUE;
        }
        shortestDist[src] = 0;
        for (int i = 0; i < V - 1; i++) { // execution times
            for (int e = 0; e < E; e++) {
                int u = edge[e][0];
                int v = edge[e][1];
                if (shortestDist[u] != Integer.MAX_VALUE && shortestDist[u] + graph[u][v] < shortestDist[v]) {
                    shortestDist[v] = shortestDist[u] + graph[u][v];
                }
            }
        }

        for (int e = 0; e < E; e++) {
            int u = edge[e][0];
            int v = edge[e][1];
            if (shortestDist[u] != Integer.MAX_VALUE && shortestDist[u] + graph[u][v] < shortestDist[v]) {
                System.out.println("Negative weight exists, no shortest path legal");
            }
        }

    }

    private static void printSolution(int dist[], int n) {
        System.out.println("Vertex      Shortest Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t \t" + dist[i]);
        }
    }

}
