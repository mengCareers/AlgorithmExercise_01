/* 815. Bus Routes
input : routes[], routes[i] is a bus route that te i-th bus repeats forever
                  e.g. routes[0] = [1, 5, 7], sequence : 1 5 7 1 5 7
        S, start bus stop
        T, destination bus stop
output: Least number of buses we must take to reach T
 * Get:
If we regard bus, i.e., route as a node, the problem will be a shortest path problem which can be solved by BFS.
We build the graph first. We define two nodes are connected if their routes share at least one bus stop.
Start points of BFS will be any routes containing S bus stop.
Target points of BFS will be any routes containing T bus stop.
 * Thought Process:
 * 
 */
package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        int N = routes.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Arrays.sort(routes[i]); // sorted for Binary Search afterwards
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isConnected(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Bus> q = new LinkedList<>();
        Set<Integer> targets = new HashSet<>();

        for (int i = 0; i < N; i++) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                visited.add(i);
                q.add(new Bus(i, 0));
            }
            if (Arrays.binarySearch(routes[i], T) >= 0) {
                targets.add(i);
            }
        }

        while (!q.isEmpty()) {
            Bus tmpBus = q.poll();
            if (targets.contains(tmpBus.busNum)) {
                return tmpBus.level + 1;
            }
            for (int neighBusNum : graph.get(tmpBus.busNum)) {
                if (!visited.contains(neighBusNum)) {
                    visited.add(neighBusNum);
                    q.add(new Bus(neighBusNum, tmpBus.level + 1));
                }
            }
        }

        return -1;
    }

    /**
     * Utility Method to check if two routes(buses) are connected
     * @param route1
     * @param route2
     * @return true if route1 and route2 share at least one element
     */
    private boolean isConnected(int[] route1, int[] route2) {
        int i1 = 0, i2 = 0;
        while (i1 < route1.length && i2 < route2.length) {
            if (route1[i1] == route2[i2]) {
                return true;
            } else if (route1[i1] < route2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        return false;
    }

    class Bus {

        int busNum;
        int level;

        public Bus(int busNum, int level) {
            this.busNum = busNum;
            this.level = level;
        }
    }
}
