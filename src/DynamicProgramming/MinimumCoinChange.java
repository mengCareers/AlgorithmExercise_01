package DynamicProgramming;

/* 322. Coin Change
input : coins[] represent denominations of coins
        amount  represent aim
output: min # of coins to reach the aim
        if can't, return -1
 * Thought Process: dynamic programming || dfs
 * Get: dfs only may cause TLE, we use DP
    - How to represent the state ? tmp(i) - min # of coins needed to make change for i
    - What is the transition func? tmp(i) = tmp(i - C) + 1
    - What is C?                   We DK. So we try each denomination, compute F(i - ci), and choose the min
                                   that is, F(i) = min(F(i - ci)) + 1 
                                   subject to i - ci >= 0
    - What is the corner case?     if i = 1, F(i) = 0
 * 
 */
/**
 *
 * @author xinrong
 */
public class MinimumCoinChange {

    public static void main(String[] args) {
        int[] coins = {2, 3};
        // 0 9999 1 1 2 2 2 3
        int[] coinsWithOne = {1, 2, 3};
        coinChange(coinsWithOne, 7);
    }

    public static int coinChange(int[] coins, int target) {
        if (target < 1) {
            return 0;
        }
        int[] tmp = new int[target + 1];
        for (int i = 1; i < tmp.length; i++) {
            int minTmp = 9999; // def val for the mini target can't depo
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int tp = tmp[i - coins[j]] + 1;
                    if (tp < minTmp) {
                        minTmp = tp;
                    }
                }
            }
            tmp[i] = minTmp;
        }
        printTmpArray(tmp);
        return tmp[tmp.length - 1];
    }

    private static void printTmpArray(int[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i] + " ");
        }
    }
}
