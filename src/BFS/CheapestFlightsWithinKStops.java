/* 787. Cheapest Flights Within K Stops
 * Thought Process:
 * Dijkstra shortest path from src 
    - but not promise shotest path, another constraint k stop
 * bfs from src, k + 1 = lvl
 * GET :
Shortest Path in Weighted Directed Graph with K level constraint
=> use BFS to satisfy K level constraint
=> update mincost[] on the fly as Dijkstra’s Algorithm
 */
package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class CheapestFlightsWithinKStops {

    /**
     *
     * @param n cities
     * @param flights src,dst,cost
     * @param src start city
     * @param dst destination city
     * @param K stops (node passes)
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int[] mincost = new int[n];
        Arrays.fill(mincost, Integer.MAX_VALUE);
        mincost[src] = 0;
        int[][] cost = new int[n][n];
        for (int[] flight : flights) {
            cost[flight[0]][flight[1]] = flight[2];
        }

        int stops = 0;
        while (!q.isEmpty()) {
            int lvlsz = q.size();
            for (int li = 0; li < lvlsz; li++) {
                int u = q.poll();
                for (int[] flight : flights) {
                    if (stops == K && flight[1] != dst) {
                        continue;
                    }
                    if (flight[0] == u) {
                        int v = flight[1];
                        if (mincost[u] + cost[u][v] < mincost[v]) {
                            mincost[v] = mincost[u] + cost[u][v];
                            q.add(v);
                        }
                    }
                }
            }
            stops++;
        }

        return mincost[dst] == Integer.MAX_VALUE ? -1 : mincost[dst];
    }
}
