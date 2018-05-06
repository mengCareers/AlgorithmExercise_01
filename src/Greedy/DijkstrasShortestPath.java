package Greedy;

/*
 *  Q:find shortest path from source to all vertices
 *
 * @author xinrong
 */
public class DijkstrasShortestPath {

    static final int V = 9;

    int minDist(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, min_idx = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                min_idx = i;
            }
        }
        return min_idx;
    }

    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            int u = minDist(dist, visited);
            visited[u] = true;
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
    }

}
