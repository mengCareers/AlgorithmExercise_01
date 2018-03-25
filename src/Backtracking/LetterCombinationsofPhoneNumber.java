/* 17. Letter Combinations of a Phone Number
input : digits
output: list of combinations of characters (phone number represent)
e.g. 
Input:Digit string "23"
      abc def
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
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

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        List<String> resource = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            resource.add(LETTERS[c - '0']);
        }
        letterCombinationsUtil("", 0, resource);
        return result;
    }

    private void letterCombinationsUtil(String comb, int curheight, List<String> resource) {
        if (curheight == resource.size()) {
            result.add(comb);
        } else {
            String curstr = resource.get(curheight);
            for (int i = 0; i < curstr.length(); i++) {
                letterCombinationsUtil(comb + curstr.charAt(i), curheight + 1, resource);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = new LetterCombinationsofPhoneNumber().letterCombinations(digits);
        System.out.println(result);
    }
}
