/*
 * Thought Process:
 * 
 */
package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class MinimumSpinningTree {

    static class Edge {

        int from, to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }

    public static List<Edge> primAlgo(List<List<Edge>> G) {
        List<Edge> mst = new ArrayList<>();
        boolean[] marked = new boolean[G.size()];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.weight < o2.weight) {
                    return -1;
                } else if (o1.weight > o2.weight) {
                    return 1;
                }
                return 0;
            }
        });
        // for Node 0
        for (Edge e : G.get(0)) {
            pq.add(e);
        }
        marked[0] = true;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (marked[e.from] && marked[e.to]) {
                continue;
            }
            marked[e.from] = true;
            for (Edge ee : G.get(e.to)) {
                if (!marked[ee.to]) {
                    pq.add(ee);
                }
            }
            marked[e.to] = true;
            mst.add(e);
        }
        return mst;
    }

    public static void KrusAlgo() {

    }
}
