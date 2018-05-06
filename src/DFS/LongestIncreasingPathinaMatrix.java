/* 329. Longest Increasing Path in a Matrix
Given an integer matrix, find the length of the longest increasing path.
From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * Thought Process:
Each point (x, y) can be the start point for dfsUtil - longestIncreasingPath from (x, y)
If memo[x][y] has been calculated, return its value.
Else, memo[x][y] = maxAnsAround + 1 (recursively), return its value
 * 
 */
package DFS;

/**
 *
 * @author xinrong
 */
public class LongestIncreasingPathinaMatrix {

    public static void main(String[] args) {
        LongestIncreasingPathinaMatrix inst = new LongestIncreasingPathinaMatrix();
        int[][] matrix = {
            {0, 0, 0},
            {1, 2, 3},
            {0, 0, 4}
        };
        int ans = inst.longestIncreasingPath(matrix);
        System.out.println(ans);
    }

    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int longestPath = 0;
        int[][] memo = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                longestPath = Math.max(longestPath, dfsUtil(i, j, matrix, memo));
            }
        }
        return longestPath;
    }

    private static int dfsUtil(int x, int y, int[][] matrix, int[][] memo) {
        if (memo[x][y] > 0) {
            return memo[x][y];
        }
        int maxAnsAround = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[0].length) {
                continue;
            }
            if (matrix[nx][ny] > matrix[x][y]) { // can move on recursively
                maxAnsAround = Math.max(maxAnsAround, dfsUtil(nx, ny, matrix, memo));
            }
        }
        memo[x][y] = 1 + maxAnsAround;
        return memo[x][y];
    }

}
