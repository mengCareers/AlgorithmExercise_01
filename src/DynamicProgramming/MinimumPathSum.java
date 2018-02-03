package DynamicProgramming;

/*
 *  Q:64. Minimum Path Sum
m * n grid filled with non-negative num, find a path from top left to bottom right 
which minimizes sum of all nums along its path
 *  Get:
M1:
dfs, get curSum compare to minSum on the fly
M2:
For each element, we consider two paths, rightwards and downwards and find the minimum sum out of those two. 
DP: dp(i, j) represents the minimum sum of the path from (i, j) to bottom right.
    we should return dp(0, 0);
    dp(i, j) = grid(i, j) + min(dp(i + 1, j), dp(i, j + 1))
e.g.
    dp(0, 0) = grid(0, 0) + min(dp(1, 0), dp(0, 1));
 */

/**
 *
 * @author xinrong
 */
public class MinimumPathSum { 
    // M1
    int minSum;
    int rows, cols;
    
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) 
            return 0;
        
        rows = grid.length;
        cols = grid[0].length;
        minSum = Integer.MAX_VALUE;
        
        dfs(grid, 0, 0, 0);
        return minSum;
    }
    public void dfs(int[][] grid, int curSum, int i, int j) {
        if (i >= rows || i < 0 || j >= cols || j < 0) 
            return;
        
        curSum += grid[i][j];
        
        if (i == rows - 1 && j == cols - 1) {      
            minSum = Math.min(minSum, curSum);
            return;
        }    
        
        dfs(grid, curSum, i , j + 1);
        dfs(grid, curSum, i + 1, j);       
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {1, 1}};
        int ans = new MinimumPathSum().minPathSum(grid);
        System.out.println(ans);
    }
    
    /* M2
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
    
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 && j != cols - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } 
                else if (i != rows - 1 && j == cols - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } 
                else if (i != rows - 1 && j != cols - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                } 
                else 
                    dp[i][j] = grid[i][j];
            }
        }
    
        return dp[0][0];
    } */
}
