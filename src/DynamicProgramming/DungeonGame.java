/* 174. Dungeon Game
state :
dp[i][j] : from (i, j) to (m - 1,n - 1) minimum initial health (0 <= i <= m - 1, 0 <= j <= n - 1)
aim state :
dp[0][0] : from (0,0) to (m - 1,n - 1) minimum initial health
transfer :
standing at dungeon[i][j], we can go either downward or rightward,
we choose the one with minimum initial health
i.e. dp[i][j] = Math.min(dp[i + 1][j], dp[i][j 1]) - dungeon[i][j];
Attention, to ensure at any point health point > 0, dp[i][j + 1] >= 1
i.e. dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
corner cases :
We add dummy row to the bottommost and dummy column to the rightmost, and set values to MAX_VALUE for they are meaningless, and we don't want them to affect dp[dp.length - 2][j] or dp[i][dp[0].length - 2]. Attention that dp[dp.length - 2][dp[0].length - 2] should be set to -dungeon[i][j] <= 0 ? 1 : -dungeon[i][j] + 1; to avoid min(MAX_VALUE, MAX_VALUE)-dungeon[i][j]
Without dummy row or column, we add many 'if's to do with corner cases :
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][dp[0].length - 1] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[dp.length - 1][i] = Integer.MAX_VALUE;
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (i == dp.length - 2 && j == dp[0].length - 2) {
                    dp[i][j] = -dungeon[i][j] <= 0 ? 1 : -dungeon[i][j] + 1;
                    continue;
                }
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

    public int calculateMinimumHP_01(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dp.length - 1][dp[0].length - 1] = -dungeon[dp.length - 1][dp[0].length - 1] <= 0 ? 1 : -dungeon[dp.length - 1][dp[0].length - 1] + 1;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i != dp.length - 1 && j != dp[0].length - 1) {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
                } else if (i != dp.length - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else if (j != dp.length - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }

    public int calculateMinimumHPWrong(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = dungeon[i - 1][j - 1];
                    continue;
                }
                if (dungeon[i - 1][j - 1] > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) - dungeon[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + dungeon[i - 1][j - 1];
                }
            }
        }
        return dp[dungeon.length][dungeon[0].length];
    }
}
