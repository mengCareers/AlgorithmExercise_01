/* 833. Find And Replace in String
For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", 
then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: 
for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 * Thought Process:
 * 
 */
package String;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class FindAndReplaceinString {

    public static void main(String[] args) {
        FindAndReplaceinString inst = new FindAndReplaceinString();
        String S = "abcd";
        int[] indexes = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        String ans = inst.findReplaceString(S, indexes, sources, targets);
        System.out.println(ans);
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }

        int iS = 0, i = 0, niS = 0;
        StringBuilder result = new StringBuilder();
        while (iS < S.length() && i < indexes.length) {
            if (map.containsKey(iS)) {
                if (checkStringUtil(S, iS, sources[map.get(iS)])) {
                    result.append(targets[map.get(iS)]);
                } else {
                    result.append(S.substring(iS, indexes[map.get(iS)] + sources[map.get(iS)].length()));
                }
                iS = iS + sources[map.get(iS)].length();
                i++;
            } else {
                result.append(S.charAt(iS));
                iS++;
            }
        }
        while (iS < S.length()) {
            result.append(S.charAt(iS));
            iS++;
        }
        return result.toString();
    }

    /**
     * Check if we can make an replacement
     * @param S
     * @param i
     * @param str
     * @return true if str starts at position i in S
     */
    private boolean checkStringUtil(String S, int i, String str) {
        int si = 0;
        while (si < str.length() && i + si < S.length()) {
            if (S.charAt(i + si) != str.charAt(si)) {
                break;
            }
            si++;
        }
        return si == str.length();
    }
}
