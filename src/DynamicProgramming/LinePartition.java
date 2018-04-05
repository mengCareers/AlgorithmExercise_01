/*
 * Thought Process:
第n - 1条直线，将平面分割为n - 1个区域
n   0 1 2 3
f(n)1 2 4 7
加了第 n 条直线，即最多加了n - 1交点，此时将其分为 2 条射线和n - 2条线段，多了2 + (n - 2)个区域
Thus, f(n) = f(n - 1) + n
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LinePartition {

    public static int maxAreaPartitioned(int n) {
        if (n == 0) {
            return 1;
        }
        return maxAreaPartitioned(n - 1) + n;
    }
    
    static int[] dp = new int[100];

    public static int maxAreaPartitionedMemorization(int n) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n]; // it will never reach here
        }
        dp[n] = maxAreaPartitioned(n - 1) + n;
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            System.out.println(maxAreaPartitionedMemorization(i));
        }

    }
}
