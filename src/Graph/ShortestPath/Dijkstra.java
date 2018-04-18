/*
Dijkstra doesn’t work for Graphs with negative weight edges, Bellman-Ford works for such graphs. Bellman-Ford is also simpler than Dijkstra and suites well for distributed systems. But time complexity of Bellman-Ford is O(VE), which is more than Dijkstra.
 * Thought Process:
=> Dijkstra helps build minDist[][] such that minDist[x][y] means the Shortest Distance from start point to (x, y). Thus, we could return minDist[destination[0]][destination[1]].
=> During Dijkstra, we use PriorityQueue to get the unvisited vertex **minVer** at the Shortest Distance from the start point instead of looping through minDist[][]. 
=> For each **minVer**, we traverse in all possible directions to determine the Shortest Distance to end points, if any such endpoint can be reached in a 'shorter' Shortest Distance previously considered, we update minDist[][].
 * 
 */
package Graph.ShortestPath;

/**
 *
 * @author xinrong
 */
public class Dijkstra {

    public static void main(String[] args) {
        int graph[][] = new int[][]{
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        singleSrcShortestPath(graph, 0);
    }

    static final int V = 9; // # of vertices

    public static void singleSrcShortestPath(int[][] graph, int src) {

        int[] shortestDist = new int[V];
        boolean[] inSet = new boolean[V];
        for (int i = 0; i < V; i++) {
            shortestDist[i] = Integer.MAX_VALUE;
            inSet[i] = false;
        }
        shortestDist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            int minVertex = findMinDistVertex(shortestDist, inSet);
            inSet[minVertex] = true;
            for (int v = 0; v < V; v++) {
                if (!inSet[v] && graph[minVertex][v] != 0) {
                    if (shortestDist[minVertex] + graph[minVertex][v] < shortestDist[v]) {
                        shortestDist[v] = shortestDist[minVertex] + graph[minVertex][v];
                    }
                }
            }
        }
        printSolution(shortestDist, V);
    }

    private static void printSolution(int dist[], int n) {
        System.out.println("Vertex      Shortest Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t \t" + dist[i]);
        }
    }

    private static int findMinDistVertex(int[] shortestDist, boolean[] inSet) {
        int minDist = Integer.MAX_VALUE;
        int minVer = -1;
        for (int i = 0; i < V; i++) {
            if (!inSet[i]) {
                if (shortestDist[i] <= minDist) {
                    minDist = shortestDist[i];
                    minVer = i;
                }
            }
        }
        return minVer;
    }

    // if 2-D
    private static int[] findMinDistVertex(int[][] shortestDist, boolean[][] inSet) {
        int minDist = Integer.MAX_VALUE;
        int[] minVer = {-1, -1};
        for (int i = 0; i < shortestDist.length; i++) {
            for (int j = 0; j < shortestDist[0].length; j++) {
                if (!inSet[i][j]) {
                    if (shortestDist[i][j] <= minDist) {
                        minDist = shortestDist[i][j];
                        minVer = new int[]{i, j};
                    }
                }
            }
        }
        return minVer;
    }
}
