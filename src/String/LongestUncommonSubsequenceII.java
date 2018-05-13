/* 522. Longest Uncommon Subsequence II
input : strs[]
output: length of longest uncommon subsequence
 * Thought Process:
for str[0], 
find one subsequence that not subsequences of others
generate all possible subsequences of all the strings 
and store int map<str, freq>
if freq == 1, get the longest among
 * Get : longest uncommon subsequence will always be one of the string
LUS will always be one of ths strings in the list.
e.g. ["ab", "abc"] will return 3 for "abc" is not the subsequence of "ab".
["ab", "abc", "abcd"] will return 4 for "abcd" is not the subsequence of "ab" or "abc".
So for each string in list, we check if it is the subsequence of the others.
If it is not the subsequence of the others, it is the candidate answer.
We get the overall longest one and return the length of it.
 */
package String;

/**
 *
 * @author xinrong
 */
public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {
        int lenLUS = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubsequence(strs[j], strs[i])) {
                    break;
                }
            }
            if (j == strs.length) {
                lenLUS = Math.max(lenLUS, strs[i].length());
            }
        }
        return lenLUS;
    }

    /**
     * 
     * @param s1
     * @param s2
     * @return true if s2 is subsequence s1 
     */
    private boolean isSubsequence(String s1, String s2) {
        int i2 = 0;
        for (int i1 = 0; i1 < s1.length() && i2 < s2.length(); i1++) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                i2++;
            }
        }
        return i2 == s2.length();
    }

    public static void main(String[] args) {
        LongestUncommonSubsequenceII inst = new LongestUncommonSubsequenceII();
        boolean ans = inst.isSubsequence("abc", "ab");
        System.out.println(ans);
    }
}
