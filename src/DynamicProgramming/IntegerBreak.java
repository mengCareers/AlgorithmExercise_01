/* 343. Integer Break
Given a positive integer n, break it into the sum of at least two positive integers 
and maximize the product of those integers. Return the maximum product you can get.
 * Thought Process:
a + b = aim
max (a * b)
m1 backtracking, list all a + b, get max * one
m2 dp[i][j] when i + j = n, i * j maximum
 * GET:
divide your number into threes unless when the last number is 4
10 = 3 * 3 * 2 * 2
11 = 3 * 3 * 3 * 2
12 = 3 * 3 * 3 * 3
     3 * 3 * 3 * 3 = threes
13 = 3 * 3 * 3 * 2 * 2
     3 * 3 * 3 = threes
p[13] = p[10] * 3
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int tp = n;
        int threes = 1;
        while (tp > 4) {
            tp = tp - 3;
            threes = threes * 3;
        }
        return tp * threes;
    }

    public int integerBreakDP(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int[] p = new int[n + 1];
        p[2] = 1;
        p[3] = 3;
        p[4] = 4;
        for (int i = 5; i <= n; i++) {
            p[i] = 3 * p[i - 3];
        }
        return p[n];
    }
}
