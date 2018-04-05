/* 四个角递推
Q: A starts at (0, 0), aims at (r, c), can only walk down or right
   B starts at (r, 0), aims at (0, c), can only walk up or right
   A and B must once meet at a cell, and the val can't be added.
   Accumulate the cells they pass until one of them reach its aim.
   Their path can't overlap.
Input : 
Output: maximum accumulated value
 * Thought Process: 
从A start, B start分别dp，
    *dp[i][j] = max(上一个方向最大的，上一个另一个方向最大的) + arr[i][j]
HOWEVER, THAT INCLUDES VALUE OF MEETING POINT
If we meet at point now, start -> now + now -> des
    *dp can solve start -> now, as for now -> des, it EQUALS TO des -> now,
THAT IS, 矩阵的四个角分别求dp，然后枚举每个点为相遇点，比较得出最大的即可
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class WorkingOut {

    public static void main(String[] args) {
        int[][] arr = {{100, 100, 100}, {100, 1, 100}, {100, 100, 100}};
        System.out.println(getCalories(arr, 3, 3));
    }

    static int getCalories(int[][] arr, int r, int c) {
        // A start -> now
        int[][] dp1 = new int[r + 2][c + 2];
        // B start -> now
        int[][] dp2 = new int[r + 2][c + 2];
        // B end -> now
        int[][] dp3 = new int[r + 2][c + 2];
        // A end -> now
        int[][] dp4 = new int[r + 2][c + 2];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i][j - 1]) + arr[i - 1][j - 1];
            }
        }
        for (int i = r; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                dp2[i][j] = Math.max(dp2[i + 1][j], dp2[i][j - 1]) + arr[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= r; i++) {
            for (int j = c; j >= 1; j--) {
                dp3[i][j] = Math.max(dp3[i - 1][j], dp3[i][j + 1]) + arr[i - 1][j - 1];
            }
        }
        for (int i = r; i >= 1; i--) {
            for (int j = c; j >= 1; j--) {
                dp4[i][j] = Math.max(dp4[i + 1][j], dp4[i][j + 1]) + arr[i - 1][j - 1];
            }
        }
        int maxn = Integer.MIN_VALUE;
        for (int i = 2; i < r; i++) {
            for (int j = 2; j < c; j++) {
                maxn = Math.max(maxn, dp1[i - 1][j] + dp2[i][j - 1] + dp3[i][j + 1] + dp4[i + 1][j]);
                maxn = Math.max(maxn, dp1[i][j - 1] + dp2[i + 1][j] + dp3[i - 1][j] + dp4[i][j + 1]);
                // maxn = max(maxn,dp1[i][j]+dp2[i][j]+dp3[i][j]+dp4[i][j]-4*mp[i][j]) WRONG
                /* FOR
                IF MEET ONLY ONCE, THERE ARE ONLY TWO WAYS OF MEETING:
A down, B right, meet, A down, B right
    +   A   +
    B   +   +
    +   +   +                 
A right B up, meet, A right, B up
    +   +   +
    A   +   +
    +   B   +
                 */

            }
        }
        return maxn;
    }
}
