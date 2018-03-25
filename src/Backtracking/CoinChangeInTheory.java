/*
 * Thought Process:
 * 
 */
package Backtracking;

/**
 *
 * @author xinrong
 */
public class CoinChangeInTheory {

    public static void main(String[] args) {
        int ans = new CoinChangeInTheory().MinimumCoinChange(6, new int[]{3});
        System.out.println(ans);
    }

    int best = Integer.MAX_VALUE;

    public int MinimumCoinChange(int money, int[] coins) {
        MinimumCoinChangeUtil(new int[80], 0, money, coins);
        return best;
    }

    /**
     *
     * @param choices Current result in State Space Tree
     * @param curheight Current level in state
     * @param money Target money amount
     * @param coins All coin values
     * @return
     */
    private void MinimumCoinChangeUtil(int[] choices, int curheight, int money, int[] coins) {
        if (money == 0) {
            // System.out.println(curheight);
            if (best > curheight) {
                best = curheight;
                System.out.println(curheight);
            }
            // USE else BELOW OR return; HERE
        } else if (money < 0) {
        } else {
            for (int i = 0; i < coins.length; i++) {
                if (money - coins[i] >= 0) {
                    choices[curheight] = coins[i];
                    MinimumCoinChangeUtil(choices, curheight + 1, money - coins[i], coins);
                }
            }
        }
    }
}
