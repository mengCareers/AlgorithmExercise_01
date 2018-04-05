/*

 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class CutRodWithHighestPrice {

    /**
     * To cut the rod in a way to get the highest price
     *
     * @param value The price of each way of the rod cutting
     * @param rodlen The length of the rod
     * @return The highest price to get
     */
    public static int cutRodWithHighestPrice(int[] value, int rodlen) {
        int[][] dp = new int[value.length + 1][rodlen + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < i) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i][j - i]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
