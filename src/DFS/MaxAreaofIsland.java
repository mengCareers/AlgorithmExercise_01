/* 695. Max Area of Island
input : grid
output: biggest connected coponents
 * Thought Process:
 * v : element
   e : connected if island 
   if 1, dfs connected 1s, cnt s
 */
package DFS;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class MaxAreaofIsland {

    boolean[][] visited;
    int rows = 0, cols = 0;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int s = 0;
                    Stack<int[]> pending = new Stack<>();
                    pending.push(new int[]{i, j});
                    visited[i][j] = true;
                    while (!pending.empty()) {
                        int[] nxt = pending.pop();
                        s++;
                        // for u adj to nxt
                        int[][] u = new int[4][2];
                        u[0] = new int[]{nxt[0] + 1, nxt[1]};
                        u[1] = new int[]{nxt[0] - 1, nxt[1]};
                        u[2] = new int[]{nxt[0], nxt[1] + 1};
                        u[3] = new int[]{nxt[0], nxt[1] - 1};
                        for (int[] uele : u) {
                            if (uele[0] >= 0 && uele[0] < rows && uele[1] >= 0 && uele[1] < cols) {
                                if (grid[uele[0]][uele[1]] == 1 && !visited[uele[0]][uele[1]]) {
                                    pending.add(uele);
                                    visited[uele[0]][uele[1]] = true;
                                }
                            }
                        }
                    }
                    ans = Math.max(ans, s);
                }
            }
        }
        return ans;
    }

}
