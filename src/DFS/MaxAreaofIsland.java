/* 695.Max Area of Island
Find the maximum area of an island in Number of Islands

 * Thought Process:
 * 
 */
package DFS;

/**
 *
 * @author xinrong
 */
public class MaxAreaofIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    int dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 0;

        return 1 + dfs(x, y + 1, grid)
                + dfs(x, y - 1, grid)
                + dfs(x + 1, y, grid)
                + dfs(x - 1, y, grid);
    }
}
