/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class DPLec {

    public static int sellGoldBar(int[] value, int barlen) {
        int[][] dp = new int[value.length + 1][barlen + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < i) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i][j - i]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static int lenLCSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static int lenLCS(String s1, String s2) {
        int max = 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }

    /**
     * dp[choice + 1][target + 1] row0 : 0, col0 : 1
     *
     * @param coins
     * @param total
     * @return
     */
    static int denoMoney(int[] coins, int total) {
        int[][] dp = new int[coins.length + 1][total + 1];
        // row0 = 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {

        int[] value = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(sellGoldBar(value, 8));

//        String s1 = "aggtab";
//        String s2 = "gxtxayb";
//        System.out.println("Length of LCSubsequence is : " + lenLCSubsequence(s1, s2));
//        String s1 = "abcdybg";
//        String s2 = "xybcdhi";
//        System.out.println("Length of LCS is : " + lenLCS(s1, s2));
//        int[] coins = {2, 3, 5, 6};
//        int total = 10;
//        System.out.println("Combination of Target : " + denoMoney(coins, total));
//        int ans = Integer.MIN_VALUE;
//        ans = findFibRecur(6);
//        ans = findFibIte(6);
//        ans = findFibMemo(6, new int[7]);
//        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
//        ans = getLongestBittonic(nums);
//        int[] coins = {1, 5, 6, 9};
//        ans = getMinimumCoins(coins, 11);
//        int[] steps = {2, 3, 1, 1, 4};
//        ans = jumpToEnd(steps);
//        printLongestBitonic(nums);
//        System.out.println(ans);
    }

    /**
     * Tablization
     *
     * @param n
     * @return
     */
    static int findFibIte(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     *
     * @param n
     * @return n + 1 th fib
     */
    static int findFibRecur(int n) {
        if (n <= 1) {
            return n;
        }
        return findFibRecur(n - 1) + findFibRecur(n - 2);
    }

    static int findFibMemo(int n, int[] hash) {
        if (hash[n] == 0 && n != 0) {
            if (n <= 1) {
                return n;
            }
            hash[n] = findFibMemo(n - 1, hash) + findFibMemo(n - 2, hash);
        }
        return hash[n];
    }

    // climb stairs
    /**
     * What we want ? max(LIS[i]) such that LIS[i] is longestIncreasingSubseq
     * until i If we think in this way, As for subproblem LIS[i], assume we know
     * from LIS[0] to LIS[i - 1], then LIS[i] = max(LIS[0] to LIS[i - 1]) + 1
     * that is called optimal substructure
     *
     * @param nums
     * @return
     */
    static int longestIncreasingSubseq(int[] nums) {
        int[] lis = new int[nums.length];
        int maxlis = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxj = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxj = Math.max(maxj, lis[j]);
                }
            }
            lis[i] = maxj + 1;
            maxlis = Math.max(maxlis, lis[i]);
        }
        return maxlis;
    }

    /**
     * What we want ? true dp[i] such that dp[i] true means we can reach i If we
     * think in this way, assume we know dp[j] true then dp[i] = dp[j] && j can
     * reach i
     *
     * @param nums
     * @return
     */
    static boolean canJumpToEnd(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && (j + nums[j] >= i)) {
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    static int jumpToEnd(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int minval = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    minval = Math.min(minval, dp[j]);
                }
            }
            dp[i] = minval + 1;
        }
        return dp[nums.length - 1];
    }

    static void reverse(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
    }

    static List<List<Integer>> reverse(List<List<Integer>> list) {
        List<List<Integer>> nlist = new ArrayList<>();
        for (List<Integer> li : list) {
            List<Integer> nli = reverseLi(li);
            nlist.add(0, nli);
        }
        return nlist;
    }

    static List<Integer> reverseLi(List<Integer> list) {
        List<Integer> nlist = new ArrayList<>();
        for (int li : list) {
            nlist.add(0, li);
        }
        return nlist;
    }

    static int[] getLIS(int[] nums) {
        int len = nums.length;
        int[] lis = new int[len];
        for (int i = 0; i < len; i++) {
            lis[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            int maxlis = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < val) {
                    maxlis = Math.max(maxlis, lis[j]);
                }
            }
            lis[i] = maxlis + 1;
        }
//        for (int i : lis) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        return lis;
    }

    /**
     * First increasing then decreasing
     *
     * @param nums
     * @return
     */
    static int getLongestBittonic(int[] nums) {
        int[] lis = getLIS(nums);
        reverse(nums);
        int[] lds = getLIS(nums);
        reverse(lds);
        reverse(nums);
        int maxsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lis[i] + lds[i] - 1 > maxsum) {
                maxsum = lis[i] + lds[i] - 1;
            }
        }
        return maxsum;
    }

    static List<List<Integer>> getItemsLIS(int[] nums) {
        List<List<Integer>> lis = new ArrayList<>();
        List<Integer> fst = new ArrayList<>();
        fst.add(nums[0]);
        lis.add(fst);
        for (int i = 1; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if ((nums[j] < nums[i]) && (lis.get(j).size() > tmp.size())) {
                    tmp = new ArrayList<>(lis.get(j));
                }
            }
            tmp.add(nums[i]);
            lis.add(tmp);
        }
        return lis;
    }

    static void printLongestBitonic(int[] nums) {
        List<List<Integer>> lis = getItemsLIS(nums);
        reverse(nums);
        List<List<Integer>> rlds = getItemsLIS(nums);
        List<List<Integer>> lds = reverse(rlds);
        reverse(nums);

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lis.get(i).size() + lds.get(i).size() - 1 > max) {
                max = lis.get(i).size() + lds.get(i).size() - 1;

            }
        }
        Set<Integer> maxIndices = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (lis.get(i).size() + lds.get(i).size() - 1 == max) {
                maxIndices.add(i);
            }
        }
        for (int id : maxIndices) {
            print(lis.get(id), lis.get(id).size() - 1);
            print(lds.get(id), lds.get(id).size());
            System.out.println();
        }
    }

    static void print(List<Integer> list, int sz) {
        for (int i = 0; i < sz; i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    static int getMinimumCoins(int[] coins, int total) {
        // make matrix
        int[][] matrix = new int[coins.length][total + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (coins[i] > j) {
                    if (i == 0) {
                        matrix[i][j] = 0;
                    } else {
                        matrix[i][j] = matrix[i - 1][j];
                    }
                } else {
                    if (i == 0) {
                        matrix[i][j] = matrix[i][j - coins[i]] + 1;
                    } else {
                        matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - coins[i]] + 1);
                    }
                }
            }
        }
        return matrix[coins.length - 1][total];
    }

}
