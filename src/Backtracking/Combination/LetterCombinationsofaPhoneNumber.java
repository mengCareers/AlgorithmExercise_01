/*
Q : 17. Letter Combinations of a Phone Number
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Thought Process:
 * 
 */
package Backtracking.Combination;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class LetterCombinationsofaPhoneNumber {

    private static final String[] LETTERS = new String[]{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> allRes = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return allRes;
        }
        char[] chs = digits.toCharArray();
        String[] candidates = new String[digits.length()];
        int ci = 0;
        for (char ch : chs) {
            candidates[ci++] = LETTERS[ch - '0'];
        }

        getCombUtil(candidates, 0, "", allRes);
        return allRes;
    }

    private void getCombUtil(String[] candidates, int lvl, String curRes, List<String> allRes) {
        if (lvl == candidates.length) {
            allRes.add(curRes);
        } else {
            for (int i = 0; i < candidates[lvl].length(); i++) {
                getCombUtil(candidates, lvl + 1, curRes + candidates[lvl].charAt(i), allRes);
            }
        }
    }
}
