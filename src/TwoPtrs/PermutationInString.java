/*
567. Permutation in String
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
In other words, one of the first string's permutations is the substring of the second string.
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
 * Thought Process:
 * for each permutation of s1, and check if s2.contains WOULD TLE
 * What if s2 contains one permutation of s1?
 * for each <ch : freq> in s1,
 * s2 satisfy NONONO
 * permutation of s1 should be consecutive in s2
 * we can restrict the length in the pattern of sliding window
 */
package TwoPtrs;

/**
 *
 * @author xinrong
 */
public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "adc", s2 = "ddca";
        boolean ans = new PermutationInString().checkInclusion(s1, s2);
        System.out.println(ans);
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[256];
        for (char c : s1.toCharArray()) {
            map[c]++;
        }
        int[] tmpMap = null;
        int l = 0, r = 0;
        for (; r < s2.length(); r++) {
            if (r == l + s1.length() - 1) {
                tmpMap = map.clone();
                char tmpCh = 0;
                boolean fault = false;
                for (int i = l; i <= r; i++) {
                    tmpCh = s2.charAt(i);
                    if (tmpMap[tmpCh] <= 0) {
                        fault = true;
                        break;
                    }
                    tmpMap[tmpCh]--;

                }
                if (!fault) {
                    return true;
                }
                l++;
            }

        }
        return false;
    }

    /**
     * WRONG _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .'
     * \\| |// `. / \\||| : |||// \ / _||||| -:- |||||- \ | | \\\ - /// | | |
     * \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\ `. . __ ."" '<
     * `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\
     * /__ _/ .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
     */
    public boolean checkInclusionWrong(String s1, String s2) {
        int[] map = new int[256];
        for (char c : s1.toCharArray()) {
            map[c]++;
        }
        for (char c : s2.toCharArray()) {
            map[c]--;
        }
        for (int i : map) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
