/*
 * Thought Process:
 * Simple Recursion
   -> dp : Store the Fibonacci numbers calculaated so far
dp usually indexed 1 .. n
but nums[] not
so we initialize dp[0] adapting to dp[1]
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class Fibonacci {
    /*
    int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
    */
    int fib (int n) {
        int f[] = new int[n + 1];
        int i;
        f[0] = 0;
        f[1] = 1;
        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
