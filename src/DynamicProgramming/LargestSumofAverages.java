/* 813.Largest Sum of Averages
partition A into at most K groups,
score is the sum of average of each group
output : largest score we can achieve
 * Thought Process:
state : largest score we can achieve by K partitions
dp[i]   
 * GET:
dynamic programing as the states form a DAG
State Transfer :
largest sum of averages from start =
max( averages of the current partition which starts at start + largest sum of averages which starts at tail + 1 )

During the recursion,

K minus by 1 each time, until K == 1, i.e., it is the last partition.
tail represents the possible last element index of the current partition which starts at start
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LargestSumofAverages {

    public double largestSumOfAverages(int[] A, int K) {
        int[] cumulativeSum = new int[A.length];
        cumulativeSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + A[i];
        }
        double[][] memo = new double[A.length][K + 1];
        return largestSumofAveragesFrom(A, K, 0, cumulativeSum, memo);
    }

    private double largestSumofAveragesFrom(int[] A, int K, int start, int[] cumulativeSum, double[][] memo) {
        if (memo[start][K] != 0) {
            return memo[start][K];
        }
        if (K == 1) {
            memo[start][1] = ((double) (cumulativeSum[A.length - 1] - cumulativeSum[start] + A[start]) / (A.length - start));
            return memo[start][1];
        }
        double num = 0;
        for (int tail = start; tail + K - 1 < A.length; tail++) {
            num = Math.max(num, ((double) (cumulativeSum[tail] - cumulativeSum[start] + A[start]) / (tail + 1 - start)) + largestSumofAveragesFrom(A, K - 1, tail + 1, cumulativeSum, memo));
        }
        memo[start][K] = num;
        return num;
    }

}
