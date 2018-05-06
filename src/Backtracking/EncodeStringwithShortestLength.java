/*
 * Thought Process:
 * 
 */
package Backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class EncodeStringwithShortestLength {

    public String encodeDP(String s) {
        String[][] dp = new String[s.length()][s.length()];

        // iterate all the length
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                String substr = s.substring(i, j + 1);
                if (substr.length() < 5) {
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;
                    // loop for trying all results we get after dividing substr into 2
                    for (int k = i; k < j; k++) {
                        if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    // loop for checking if substr itself with some pattern can be repeated
                    String pattern = kmp(substr);
                    if (pattern.length() == substr.length()) {
                        continue;
                    }
                    String patternEncoded = substr.length() / pattern.length() + "[" + dp[i][i + pattern.length() - 1] + "]";
                    if (patternEncoded.length() < dp[i][j].length()) {
                        dp[i][j] = patternEncoded;
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        EncodeStringwithShortestLength inst = new EncodeStringwithShortestLength();
        String s = "abcabcab";
        String res = inst.kmp(s);
        System.out.println(res);
    }

    private String kmp(String s) {
        int len = s.length();
        int[] LPS = new int[len];

        int i = 1, j = 0;
        LPS[0] = 0;
        while (i < len) {
            if (s.charAt(i) == s.charAt(j)) {
                LPS[i++] = ++j;
            } else if (j == 0) {
                LPS[i++] = 0;
            } else {
                j = LPS[j - 1];
            }
        }

        int patternLen = len - LPS[len - 1];
        if (patternLen != len && len % patternLen == 0) {
            return s.substring(0, patternLen);
        } else {
            return s;
        }
    }
}
