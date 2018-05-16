/*790. Domino and Tromino Tiling
input : N
output: # of ways to tile a 2 x N board
 * Get:
For XX only problem, actually 2 types of files: 
state : 
    (i) length of board
    dp(i) # of ways to tile a 2 x i board
    answer is dp(N)
transfer :
    at i, we have 2 choices, place horizontally WE HAVE TO PLACE SECOND TILE ALSO HORIZONTALLY dp(n) = dp(n - 2)
                             place vertically   dp(n) = dp(n - 1)
    we need to calculate # of ways in total, i.e., dp(n - 1) + dp(n - 2)
For current problem :
state : 
    (i) length of board
    dp(i) # of ways to tile a 2 x i board
    dp_up(i) # of ways to tile a 2 * i board except for the last lower grid
    dp_down(u) # of ways to tile a 2 * i board except for the last upper grid
    answer is dp(N)
 * Actually 6 types of tiles
 * Let's consider the last tile, at dp(n) we have 4 choices
dp(n) = dp(n - 1)
 + dp(n - 2)
 + dp_up(n - 1)
 + dp_down(n - 1)
 * What is dp_up and dp_down ? Let's consider the last tile,
dp_up(n) = dp_down(n - 1) + dp(n - 2)
dp_up(n - 1) = dp_down(n - 2) + dp(n - 3)
Similarly,
dp_down(n) = dp_up(n - 1) + dp(n - 2)
dp_down(n - 1) = dp_up(n - 2) + dp(n - 3)
 +
dp(n) = dp(n - 1) + [dp(n - 2) + dp_down(n - 2) + dp(n - 3) + dp_up(n - 2)] + dp(n - 3)
dp(n) = dp(n - 1) + dp(n - 1) + dp(n - 3)
dp(n) = 2 * dp(n - 1) + dp(n - 3)
Bottom-up is faster than   Top-down without Recursion
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class DominoandTrominoTiling {

    public int numTilings(int N) {
        if (N == 0 || N == 1 || N == 2) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] % 1000000007 + dp[i - 3] % 1000000007) % 1000000007;
        }
        return dp[N];
    }

    public int numTilingsTLE(int N) {
        if (N <= 2) {
            return N;
        }
        if (N == 3) {
            return 5;
        }
        return (2 * numTilingsTLE(N - 1) % 1000000007 + numTilingsTLE(N - 3) % 1000000007) % 1000000007;
    }

}
