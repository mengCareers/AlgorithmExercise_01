/* 651. Four Keys Keyboard
Key 1 : 'A'
Key 2 : Ctrl - A
Key 3 : Ctrl - C
Key 4 : Ctrl - V
input : N keystrokes
output: maximum numbers of 'A' can print on screen
 * Thought Process:
 * if 'A' 1 +
 * Get :
Aim : maximum numbers of 'A' after N key presses.
dp[i] : maximum numbers of 'A' after i key presses.
There are 2 possibilities for the last move,

if last move is Adding, dp[i] = dp[i - 1] + 1;
if last move is Multiplying, dp[i] = dp[i - (x + 1)] * x;
To add x - 1 more copies, i.e., to form x chunks, we need x + 1 key presses.
e.g. original chunk: AA, want to add 3 more copies, that is, to form 4 chunks - AAAAAAAA, we need 5 key presses : Ctrl-A Ctrl-C, Ctrl-V, Ctrl-V, Ctrl-V.
For simplicity, we assign i - (x + 1) to j, then dp[i] = dp[j] * (i - j - 1), for i - j - 1 > 0, i.e. j < i - 1
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class FourKeysKeyboard {

    public int maxA(int N) {
        int[] dp = new int[N + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }
}
