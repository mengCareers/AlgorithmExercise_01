/* 17. Letter Combinations of a Phone Number
input : digits
output: list of combinations of characters (phone number represent)
e.g. 
Input:Digit string "23"
      abc def
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Thought Process:
 * m is not a fix value in this problem
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class LetterCombinationsofPhoneNumber {

    private static final String[] LETTERS = new String[]{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> result;
    List<String> letters;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        letters = new ArrayList<>();
        for (char i : digits.toCharArray()) {
            letters.add(LETTERS[i - '0']);
        }
        int curptr = 0;
        dfs("", curptr);
        return result;
    }

    private void dfs(String cur, int curptr) {
        if (curptr == letters.size()) {
            result.add(cur);
            return;
        }
        String letter = letters.get(curptr);
        for (int i = 0; i < letter.length(); i++) {
            dfs(cur + letter.charAt(i), curptr + 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = new LetterCombinationsofPhoneNumber().letterCombinations(digits);
        System.out.println(result);
    }
    /*
    public List<String> letterCombinationsWrong(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        d = digits.toCharArray();
        int n = digits.length();
        int[] res = new int[n];
        int curptr = 0;
        util(res, curptr);
        return result;
    }

    void util(int[] res, int curptr) {
        if (curptr == res.length) {
            printres(res);
            return;
        }
        for (int i = 0; i < 3; i++) {
            res[curptr] = i;
            util(res, curptr + 1);
        }
    }

    void printres(int[] res) {
        // res[i] : digit i pick res[i]th char
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(LETTERS[d[i] - '0'].charAt(res[i]));
        }
        result.add(sb.toString());
    }
     */
}
