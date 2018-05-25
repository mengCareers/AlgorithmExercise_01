/* 413.Arithmetic Slices
Definition: a sequence of number is called arithmetic slices
            + len >= 3
            + consecutive differences are the same
e.g. 
1   2 F
1   3   4   F
1   4   7   T
input : A
output: # of arithmetic slices in A
 * Thought Process:
Exhaustive search, for any consecutive sequence len >= 3 of see if they satisfy
What will be the cost? 
We can't accept.
Is it a DAG? directed ? yes, only check numbers after it, can't form cycle
may be DP
Let's find 最优子结构 and 子问题重叠
dp[i] represent # of arithmetic slice added when we count A[i]
if it can be included into previous Ar slice, dp[i] = 1 + dp[i - 1];   
e.g. 
	1 2 3  
	1 2 3 4 -> 2 slices added : 1234 234
	1 2 3 4 5 -> 3 slices added : 12345 2345 345
	1 2 3 4 5 6 -> 4 slices added : 123456 23456 3456 456
so dp[i] = 1 + dp[i - 1]
if it is building new one, dp[i] = dp[i - 1];
we aim to count the total number.
if it can be included into previous Ar slice, sum += dp[i];
if it is building new one, sum remain until we built a new one, sum++
how do we check if it can be included into previous? if A[i] - A[i - 1] == A[i - 2] - A[i - 1]  and ableToAppend equals to true, for ableToAppend will be set false when we start to build a new slice, will be set true when have a built an arithmetic slice with length == 3.

                    
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length + 1];
        int numOfArSlices = 0;
        boolean ableToAppend = true;
        for (int i = 3; i < dp.length; i++) {
            if (A[i - 1] - A[i - 2] == A[i - 2] - A[i - 3]) {
                dp[i] = 1 + dp[i - 1];
                if (ableToAppend) {// 1 2 3 4 5 6
                    numOfArSlices += dp[i];
                } else {
                    numOfArSlices++;
                    ableToAppend = true;
                }
            } else {
                ableToAppend = false;
                dp[i] = 0;
            }
        }
        return numOfArSlices;
    }

    public int numberOfArithmeticSlicesGood(int[] A) {
        int[] dp = new int[A.length + 1];
        int numOfArSlices = 0;
        boolean ableToAppend = true;
        for (int i = 3; i < dp.length; i++) {
            if (A[i - 1] - A[i - 2] == A[i - 2] - A[i - 3]) {
                dp[i] = 1 + dp[i - 1];
                numOfArSlices += dp[i];
            }
        }
        return numOfArSlices;
    }
}
