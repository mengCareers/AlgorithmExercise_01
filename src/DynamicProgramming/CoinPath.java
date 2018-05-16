/*
input : A[] starts at 1, ends at N,
        B denotes that from any place i in A, can jump to any one of the place i + 1, i + 2, .. i + B
                if you step on i, you have to pay Ai coins, if Ai == -1, means can't jump to
output: minimum coins to reach N, return the path of indexes 
 * Thought Process:
State :
( i ) - index of current step, d( i ) - the minimum cost if we start at ( i ) to reach ( N )
If we define state in this way, the answer will be d( 1 )
Transfer :
when we step on ( i ), we have B choices, i.e., we can decide to step on any one of them as below :
            i + 1, d(i) = A[i] + d(i + 1)
            i + 2, d(i) = A[i] + d(i + 2)
            i + 3, d(i) = A[i] + d(i + 3)
            ...
            i + B, d(i) = A[i] + d(i + B)
We choose the minimum one among them. That is,

d(i) = A[i] + min(d(i + 1), d(i + 2), ..., d(i + B));
To avoid duplicate calculations on subproblems, we use memorization technique, i.e., memo[].
To trace back and print out the solution pattern in the end, we use next[].
 */
package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class CoinPath {

    public static void main(String[] args) {
        CoinPath inst = new CoinPath();
        int[] A = {1, 2, 4, -1, 2};
        int B = 1;
        List<Integer> path = inst.cheapestJump(A, B);
        System.out.println(path);
    }

    public List<Integer> cheapestJump(int[] A, int B) {
        int[] memo = new int[A.length];
        Arrays.fill(memo, -1);
        int[] next = new int[A.length];
        Arrays.fill(next, -1);
        recursionUtil(A, B, 0, next, memo);
        List<Integer> path = new ArrayList<>();
        path.add(1);
        for (int i = 0; i < A.length && next[i] >= 0; i = next[i]) {
            int nxt = next[i] + 1;
            path.add(nxt);
        }
        if (path.contains(A.length)) {
            return path;
        }
        return new ArrayList<>();
    }

    private int recursionUtil(int[] A, int B, int start, int[] next, int[] memo) {
        if (memo[start] != -1) {
            return memo[start];
        }
        if (start == A.length - 1) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 1; i <= B; i++) {
            if (start + i < A.length && A[start + i] != -1) {
                int tmpAns = recursionUtil(A, B, start + i, next, memo);
                if (tmpAns < minCost) {
                    minCost = tmpAns;
                    minIdx = start + i;
                }
            }
        }
        next[start] = minIdx;
        memo[start] = A[start] + minCost;
        return memo[start];
    }

}
