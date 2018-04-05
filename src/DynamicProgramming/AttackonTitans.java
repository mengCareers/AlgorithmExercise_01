/* 带限制条件的计数递推dp
Q:给n个士兵排队，每个士兵三种G、R、P可选，求最少有m个连续G士兵，最多有k个连续R士兵的排列的种数
 * Thought Process:
#(最多有n个连续G士兵，最多有k个连续R士兵)
-
#(最多有m - 1个连续G士兵，最多有k个连续R士兵)
=
#(少多有m个连续G士兵，最多有k个连续R士兵)
WHY ?
    有5家公司给你机会做六个月以内的实习， 其中有2家公司给你机会做两个月以内的实习，那么其余三家公司给你机会做至少三个月的实习
THEN AIM TO 求出最多u个连续G士兵 且最多v个连续R士兵的排列方案数
dp[i][0] 第i个是G 最多u个连续G士兵 且最多v个连续R士兵的排列方案数
dp[i][1] 第i个是R 最多u个连续G士兵 且最多v个连续R士兵的排列方案数
dp[i][2] 第i个是P 最多u个连续G士兵 且最多v个连续R士兵的排列方案数
当第i个为P时    dp[i][2]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
当第i个为G时
    if i <= u,   dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
    if i == u+1, dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] - 1  要排除前u个都放了G的情况
    if i > u+1,  dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] - dp[i-u-1][1] - dp[i-u-1][2] 要排除从i-1到i-u位置都放了G的情况
当第i个为R时
    if i <= v,   dp[i][1]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]
    if i == v+1, dp[i][1]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]-1;         要排除前v个都放了R的情况
    if i > v+1,  dp[i][1]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]-dp[i-v-1][0]-dp[i-v-1][2];          要排除从i-1到i-v位置都放了R的情况
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class AttackonTitans {

    public static void main(String[] args) {
        System.out.println(getPermutationTitans(3, 2, 2));
    }

    /**
     *
     * @param n
     * @param m at least m G consecutive
     * @param k at most v R consecutive
     * @return
     */
    public static int getPermutationTitans(int n, int m, int k) {
        return getPermutationTitansUtil(n, n, k) - getPermutationTitansUtil(n, m - 1, k);
    }

    /**
     *
     * @param n
     * @param u at most u G consecutive
     * @param v at most v R consecutive
     * @return
     */
    public static int getPermutationTitansUtil(int n, int u, int v) {
        int[][] dp = new int[n + 1][3];
        dp[0][0] = 1;
        dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i <= n; i++) {
            int sum = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][2] = sum;
            if (i <= u) {
                dp[i][0] = sum;
            }
            if (i == u + 1) {
                dp[i][0] = sum - 1;
            }
            if (i > u + 1) {
                dp[i][0] = sum - dp[i - u - 1][1] - dp[i - u - 1][2];
            }
            if (i <= v) {
                dp[i][1] = sum;
            }
            if (i == v + 1) {
                dp[i][1] = sum - 1;
            }
            if (i > v + 1) {
                dp[i][1] = sum - dp[i - v - 1][0] - dp[i - v - 1][2];
            }
        }
        return dp[n][0] + dp[n][1] + dp[n][2];
    }
}
