/* 803. Bricks Falling When Hit
We have a grid of 1s(brcks) and 0s.
A brick will not drop 
if and only if it is direcly connected to the top of the grid
                                       or at least one of its adjacennt bricks
 * Thought Process:
 * Union Find
 * Get:
instead of looking at the graph as a series of sequential cuts, we'll look at the graph after all the cuts, and reverse each cut.
include .size operation to tell the size of the component by whenever parent[a] = b send b's size to a
include .top  operation to tell the size of the roof or the component connected to the top edge
add "source" node with label R * C where all nodes on the top edge are connected to "source"
add A[][], grid after all the cuts have happened
if we cut (r, c), grid[r][c] was 0, then return 0
else look at the size of the new roof after adding this brick at (r, c), and compare them to find the number of dropped bricks
 */
package Graph.ConnectedComponent;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class BricksFallingWhenHit {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int[][] gridAfter = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            gridAfter[r] = grid[r].clone();
        }
        for (int[] hit : hits) {
            gridAfter[hit[0]][hit[1]] = 0;
        }
        UF uf = new UF(rows * cols + 1);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (gridAfter[r][c] == 1) {
                    int i = r * cols + c;
                    if (r == 0) {
                        uf.union(i, rows * cols);
                    }
                    if (r > 0 && gridAfter[r - 1][c] == 1) {
                        uf.union(i, (r - 1) * cols + c);
                    }
                    if (c > 0 && gridAfter[r][c - 1] == 1) {
                        uf.union(i, r * cols + (c - 1));
                    }
                }
            }
        }
        int t = hits.length;
        int[] result = new int[t--];
        while (t >= 0) {
            int r = hits[t][0];
            int c = hits[t][1];
            int preRoof = uf.top();

            // reverse
            if (grid[r][c] == 0) {
                t--;
            } else {
                int i = r * cols + c;
                for (int di = 0; di < 4; di++) {
                    int nr = r + dirs[di][0];
                    int nc = c + dirs[di][1];
                    if (0 <= nr && nr < rows && 0 <= nc && nc < cols && gridAfter[nr][nc] == 1) {
                        uf.union(i, nr * cols + nc);
                    }
                }
                if (r == 0) {
                    uf.union(i, rows * cols);
                }
                gridAfter[r][c] = 1;
                result[t--] = Math.max(0, uf.top() - preRoof - 1);
            }
        }
        return result;
    }

    class UF {

        int[] parent;
        int[] sz;
        int[] rank;

        public UF(int cnt) {
            parent = new int[cnt];
            sz = new int[cnt];
            rank = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                parent[i] = i;
            }
            Arrays.fill(sz, 1);
        }

        public int top() {
            return size(sz.length - 1) - 1;
        }

        public int size(int x) {
            return sz[find(x)];
        }

        public void union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) {
                return;
            }
            if (rank[xr] < rank[yr]) {
                int tmp = yr;
                yr = xr;
                xr = tmp;
            }
            if (rank[xr] == rank[yr]) {
                rank[xr]++;
            }
            sz[xr] += sz[yr];
            parent[yr] = xr;
        }

        public int find(int x) {
            if (parent[x] != x) { // not the root
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
