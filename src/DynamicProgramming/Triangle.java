/* 120.Triangle
input : List<List<Integer>> triangle
output: minimum path sum from top to bottom, each step you may move to adjacent numbers on the row below
 * Thought Process:
The problem is to get the minimum path sum rooted at (0,0).
If we define STATE as dp[i][j] the minimum path sum rooted at (i,j),
then the FINAL STATE and AIM STATE is dp[0][0] as the minimum path sum rooted at (0,0),
STATE TRANSITION will be as below :

Assume that we are standing at (i,j), 
the minimum path sum rooted at (i,j) can be generated from either the minimum path sum rooted at (i+1,j) or the minimum path sum rooted at (i+1,j+1). We will select the smaller one. 
The rule is applied except for the last row. The minimum path sums rooted at the values in the last row equal to the values themselves.
  dp[i][j] = triangle[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]) 
        for 0 <= i < triangle.size() - 1, 0 <= j < triangle.get(i).size();
  dp[i][j] = triangle[i][j];
	for i = triangle.size() - 1;
 * 
 */
package DynamicProgramming;

import java.util.List;

/**
 *
 * @author xinrong
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size(), cols = triangle.get(rows - 1).size();
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (i == rows - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
