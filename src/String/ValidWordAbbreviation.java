/* 408. Valid Word Abbreviation
Given a non-empty string s and an abbreviation abbr, 
return whether the string matches with the given abbreviation.
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class ValidWordAbbreviation {

    public static void main(String[] args) {
        ValidWordAbbreviation inst = new ValidWordAbbreviation();
        String word = "internationalization";
        String abbr = "i5a11o1";
        boolean res = inst.validWordAbbreviation(word, abbr);
        System.out.println(res);
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int ai = 0, wi = 0;
        while (ai < abbr.length() && wi < word.length()) {
            char ch = abbr.charAt(ai);
            if (Character.isAlphabetic(ch)) {
                if (word.charAt(wi) != ch) {
                    return false;
                }
                ai++;
                wi++;
            } else {
                int di = ch - '0';
                if (di == 0) {
                    return false;
                }
                while (++ai < abbr.length() && Character.isDigit(abbr.charAt(ai))) {
                    di = di * 10 + (abbr.charAt(ai) - '0');
                }
                if (di > word.length() - wi) {
                    return false;
                }
                while (di > 0) {
                    wi++;
                    di--;
                }
            }
        }
        return wi == word.length() && ai == abbr.length();
    }
}
