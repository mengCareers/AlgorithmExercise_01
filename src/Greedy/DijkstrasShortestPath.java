package Greedy;

/*
 *  Q:find shortest path from source to all vertices
 *  Thought Process: 
generate s SPT with given source as root
maintain two sets, one contains included, on contains not yet indcluded
find a vertex in not yet included set which as minimum dist from source
 *  Get:
set sptSet has been finalised
assign a dist val to all vertices in input
while sptSet no include all 
    pick u which not in sptSet and has min dis
    include u
    update dist val of all adj vertices of u

 */

/**
 *
 * @author xinrong
 */
public class DijkstrasShortestPath {   
    static final int V = 9;
    
    // find vertext with mi dist
    int minDist(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_idx = -1;
        for (int i = 0 ; i < V; i++) {
            if (!sptSet[i] && dist[i] <= min) {
                min = dist[i];
                min_idx = i;
            }
        }
        return min_idx;
    }

    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V]; // hold shortest dist from src to i
        boolean[] sptSet = new boolean[V]; // true if v included
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i]= false;
        }
        dist[src] = 0;
        // find shortest path for all vertices
        for (int i = 0; i < V - 1; i++) {
            int u = minDist(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++) {
                // update dist[v] if noot in sptSet && connect to u && total weight of path from src to v through u < dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
    }
        
}
