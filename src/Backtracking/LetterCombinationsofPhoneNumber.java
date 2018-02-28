/* 17. Letter Combinations of a Phone Number
input : digits
output: list of combinations of characters (phone number represent)
e.g. 
Input:Digit string "23"
      abc def
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Thought Process:
 * m is not a fix value in this problem
    "abc" "def"
res ad
    ae
    af
    bd
    be
    bf
    cd
    ce
    cf
cptr means which word and res[cptr]
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

    List<String> result = new ArrayList<>();
    List<String> lst;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return result;
        char[] cd = digits.toCharArray(); //'2' '3'
        lst = new ArrayList<>(); // "abc" "def"
        for (char c : cd)
            lst.add(LETTERS[c - '0']);
        dfs("", 0);
        return result;
    }

    private void dfs(String cur, int cptr) {
        if (cptr == lst.size()) {
            result.add(cur);
            return;
        }
        String str = lst.get(cptr);
        for (int i = 0; i < str.length(); i++) {        
            dfs(cur + str.charAt(i), cptr + 1);
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
