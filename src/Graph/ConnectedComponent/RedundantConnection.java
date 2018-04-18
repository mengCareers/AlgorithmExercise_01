/*
 * Thought Process:
 * 
 */
package Graph.ConnectedComponent;

/**
 *
 * @author xinrong
 */
public class RedundantConnection {

    int[] pre;

    public int[] findRedundantConnection(int[][] edges) {
        pre = new int[edges.length + 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (find(u) == find(v)) {
                return edge;
            } else {
                union(u, v);
            }
        }
        return null;
    }

    private void union(int u, int v) {
        pre[find(u)] = find(v);
    }

    private int find(int x) {
        int r = x;
        while (r != pre[r]) {
            r = pre[r];
        }
        // r is the root now
        int i = x, j;
        while (r != pre[i]) {
            j = pre[i];
            pre[i] = r;
            i = j;
        }
        return r;
    }
}
