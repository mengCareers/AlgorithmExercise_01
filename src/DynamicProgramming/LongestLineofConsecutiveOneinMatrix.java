/*
Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3
 * Thought Process: DFS
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LongestLineofConsecutiveOneinMatrix {

    public int longestLine(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        int ones = 0;
        int[][][] dp = new int[M.length][M[0].length][4];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    dp[i][j][0] = j - 1 >= 0 ? 1 + dp[i][j - 1][0] : 1;
                    dp[i][j][1] = i - 1 >= 0 ? 1 + dp[i - 1][j][1] : 1;
                    dp[i][j][2] = (i - 1 >= 0 && j - 1 >= 0) ? 1 + dp[i - 1][j - 1][2] : 1;
                    dp[i][j][3] = (i - 1 >= 0 && j + 1 < M[0].length) ? 1 + dp[i - 1][j + 1][3] : 1;
                    ones = Math.max(ones, getMax(dp[i][j][0], dp[i][j][1], dp[i][j][2], dp[i][j][3]));
                }
            }
        }
        return ones;
    }
    
    private static int getMax(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
}
