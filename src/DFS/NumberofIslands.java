/*200. Number of Islands
input : grid[][] of '1's (land) and '0's (water), 
output: the # of islands surrounded by water and is formed by connecting adjacent lands horizontally or vertically
 * Thought Process:
 * 
 */
package DFS;

/**
 *
 * @author xinrong
 */
public class NumberofIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cnt = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
        dfs(x + 1, y, grid);
        dfs(x - 1, y, grid);
    }
}
