/* 568. 
 * Thought Process:
 * 
 */
package DFS;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class MaximumVacationDays {

    public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] memo = new int[flights.length][days[0].length];
        for (int[] m : memo) {
            Arrays.fill(m, Integer.MIN_VALUE);
        }
        return dfsUtil(flights, days, 0, 0, memo);
    }

    private static int dfsUtil(int[][] flights, int[][] days, int curCity, int curWeek, int[][] memo) {
        if (curWeek == days[0].length) {
            return 0;
        }
        if (memo[curCity][curWeek] != Integer.MIN_VALUE) {
            return memo[curCity][curWeek];
        }
        int maxVac = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[curCity][i] == 1 || curCity == i) {
                int vac = days[i][curWeek] + dfsUtil(flights, days, i, curWeek + 1, memo);
                maxVac = Math.max(maxVac, vac);
            }
        }
        memo[curCity][curWeek] = maxVac;
        return maxVac;
    }
}
