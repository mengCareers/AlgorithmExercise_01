/*
A grid coordinate (x, y) can be added to result list only if it can reach the Pacific and Atlantic.
So we construct boolean[][] canReachPacific and boolean[][] canReachAtlantic to indicate the results.
How do we build these two arrays ? We use DFS.
Instead of DFS from each candidate cell, we DFS from each target cell. That’s the idea of the Reverse Thinking.
 * Thought Process:
 * 
 */
package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<int[]> res = pacificAtlantic(matrix);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }
    /*
    static int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] pacVis = new boolean[rows][cols];
        boolean[][] atlVis = new boolean[rows][cols];

        //pacific horizontal edge DFS
        for (int i = 0; i < cols; i++) {
            if (!pacVis[0][i]) {
                pacVis[0][i] = true;
                dfs(0, i, rows, cols, matrix, pacVis);
            }
        }

        //pacific vertical edge DFS
        for (int i = 0; i < rows; i++) {
            if (!pacVis[i][0]) {
                pacVis[i][0] = true;
                dfs(i, 0, rows, cols, matrix, pacVis);
            }
        }

        //atlantic horizontal edge DFS
        for (int i = 0; i < rows; i++) {
            if (!atlVis[i][cols - 1]) {
                atlVis[i][cols - 1] = true;
                dfs(i, cols - 1, rows, cols, matrix, atlVis);
            }
        }

        //atlantic vertical edge DFS
        for (int i = 0; i < cols; i++) {
            if (!atlVis[rows - 1][i]) {
                atlVis[rows - 1][i] = true;
                dfs(rows - 1, i, rows, cols, matrix, atlVis);
            }
        }

        //Now check the common visited cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacVis[i][j] && atlVis[i][j]) {
                    ans.add(new int[]{i, j});
                }
            }
        }
        return ans;
    }

    private static void dfs(int i, int j, int row, int col, int[][] matrix, boolean[][] visited) {
        for (int[] d : dir) {
            int ii = i + d[0];
            int jj = j + d[1];
            if (ii >= 0 && ii < row && jj >= 0 && jj < col && matrix[i][j] <= matrix[ii][jj] && !visited[ii][jj]) {
                visited[ii][jj] = true;
                dfs(ii, jj, row, col, matrix, visited);
            }
        }
    }
     */

    private static int[][] ADJS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];
        // ------
        for (int j = 0; j < cols; j++) {
            if (!canReachPacific[0][j]) {
                canReachPacific[0][j] = true;
                dfSearch(0, j, matrix, canReachPacific);
            }
        }
        // |
        // |
        // |
        for (int i = 0; i < rows; i++) {
            if (!canReachPacific[i][0]) {
                canReachPacific[i][0] = true;
                dfSearch(i, 0, matrix, canReachPacific);
            }
        }

        // |
        //  ------
        for (int j = 0; j < cols; j++) {
            if (!canReachAtlantic[rows - 1][j]) {
                canReachAtlantic[rows - 1][j] = true;
                dfSearch(rows - 1, j, matrix, canReachAtlantic);
            }
        }

        // |
        // |
        //_|
        for (int i = 0; i < rows; i++) {
            if (!canReachAtlantic[i][cols - 1]) {
                canReachAtlantic[i][cols - 1] = true;
                dfSearch(i, cols - 1, matrix, canReachAtlantic);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private static void dfSearch(int x, int y, int[][] matrix, boolean[][] visited) {
        for (int[] adj : ADJS) {
            int nx = adj[0] + x;
            int ny = adj[1] + y;
            if (nx >= 0 && nx <= matrix.length - 1 && ny >= 0 && ny <= matrix[0].length - 1 && matrix[nx][ny] >= matrix[x][y] && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfSearch(nx, ny, matrix, visited);
            }
        }
    }

}
