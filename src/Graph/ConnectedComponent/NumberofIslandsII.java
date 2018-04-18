/* 305.Number of Islands II
count the number of islands after each addLand operation.
 * Thought Process:
Union Find
if connected, total # change also
if adj are islands :
1 0 1   --- 2
to 
1 1 1   --- 1
if adj is island :
.. That would be fluffy, can we recount the Disjoint Set each time?
that's not fluffy, if nei is in another island, --
 * We can also answer : 
How many islands in total?
Which island is pointA belonging to?
Are pointA and pointB connected?
 *  Get : 
* Union Find in undirected graph, represented by matrix m * n.
=> For each grid x * n + j, pre(x * n + j) stores its parent, -1 initially. Thus, -1 indicates that we have not counted it as part of land.
=> At each grid pt which we added land to,
pre[pt] = pt; // assume isolated
cntOfIsland++;
=> For its adjacent grids, we check if it has been counted as the same island. if not, we do UNION and update the pt and the cntOfIsland.

                if (pt != rnpt) {
                    // if neighbor is in another island
                    pre[pt] = rnpt;
                    pt = rnpt;
                    cntOfIsland--;
                }
 * 
 */
package Graph.ConnectedComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class NumberofIslandsII {

    int[] pre;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        pre = new int[m * n];
        Arrays.fill(pre, -1);
        int x = 0, y = 0, nx = 0, ny = 0;
        int cntOfIsland = 0;
        for (int[] pos : positions) {
            x = pos[0];
            y = pos[1];
            int pt = n * x + y;
            pre[pt] = pt; // assume isolated
            cntOfIsland++;

            for (int[] dir : dirs) {
                nx = x + dir[0];
                ny = y + dir[1];
                int npt = nx * n + ny;
                if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1 || pre[npt] == -1) {
                    continue;
                }
                int rnpt = find(npt);
                if (pt != rnpt) {
                    // if neighbor is in another island
                    pre[pt] = rnpt;
                    pt = rnpt;
                    cntOfIsland--;
                }
            }
            result.add(cntOfIsland);
        }
        return result;
    }

    private int find(int x) {
        int r = x;
        while (pre[r] != r) {
            r = pre[r];
        }
        // r is the root
        int i = x, j;
        while (i != r) {
            j = pre[x];
            pre[x] = r;
            i = j;
        }
        return r;
    }
}
