/* 139.
input : s, wordDict
    the same word may be reused n times in the segmentation
    dictionary does not contain dup
output: true if s can be segmented into a sequence of one or more dictionary words
 * Thought Process:
The problem is to check if s[0..slen-1] can be segmented into dictionary words,
if we define STATE dp[i] as s[0, i-1] can be segmented into dictionary words, the AIM STATE is dp[slen].
STATE TRANSFER as below:

if we stand at dp[i], 
dp[i] is true if there exists a j (0 <= j < i) such that 
(dp[j] && wordDict.contains(s.substring(j, i)));
In this case, dp[0] does not make sense, however, we should take care of its value in case it affects the values generated from it. dp[0] && wordDict.contains(s.substring(0, i)) should make dp[i] true, so we set dp[0] true in default.
The Bottom-up DP is as below:


leetcode
    j   i
    
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
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreakTopDownn(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return wordBreakRecur(s, new HashSet<>(wordDict), 0, memo);
    }

    private boolean wordBreakRecur(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                if (wordBreakRecur(s, wordDict, end, memo)) {
                    return memo[start] = true;
                }
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        WordBreak inst = new WordBreak();
        inst.wordBreak(s, wordDict);
    }
}
