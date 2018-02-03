package DynamicProgramming;

/* 322. Coin Change
input : coins[] represent denominations of coins
        amount  represent aim
output: min # of coins to reach the aim
        if can't, return -1
 * Thought Process: dynamic programming + dfs
 * Get: dfs only may cause TLE, we use DP
    - How to represent the state ? F(S) - min # of coins needed to make change for S using coins[]
    - What is the transition func? F(S) = F(S - C) + 1
    - What is C?                   We DK. So we try each denomination, compute F(S - ci), and choose the min
                                   that is, F(S) = min(F(S - ci)) + 1 
                                   subject to S - ci >= 0
    - What is the corner case?     if S = 1, F(S) = 0
                                   if n = 0, F(S) = -1
    - How to optimize?             cache the solutions of the subproblems
 * 
 */

/**
 *
 * @author xinrong
 */
public class CoinChange {
    
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return coinChangeUtil(coins, amount, new int[amount]);
    }    
    
    public int coinChangeUtil(int[] coins, int rem, int[] F) {
        if (rem < 0)
            return -1;
        if (rem == 0)
            return 0;
        if (F[rem - 1] != 0)
            return F[rem - 1];
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeUtil(coins, rem - coin, F);
            if (res >= 0 && res < min) // Q : when do we min = 1 + res ? 
                min = 1 + res;         // A : get minimum(F(S - ci))             
        }
        F[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return F[rem - 1];
    }
    
}
