/* 520. Detect Capital
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Thought Process:
A word starts with capital is valid if
all the rest are lowercase OR all the rest are uppercase
A word starts with lowercase is valid if
all the rest are lowercase
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        boolean isUpper = false;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            isUpper = true;
        }
        int pattern = detectUtil(word, 1, word.length() - 1);
        if (isUpper) {
            return pattern == 1 || pattern == 2;
        }
        return pattern == 1;
    }

    /**
     * To classify the capital pattern in word from index si to ei (inclusive)
     *
     * @param word
     * @param si
     * @param ei
     * @return 1 if characters within [si, ei] are all lowercase, 2 if
     * uppercase, 0 if not uniform
     */
    private int detectUtil(String word, int si, int ei) {
        boolean isUpper = false;
        char[] wordArr = word.toCharArray();
        if (wordArr[si] >= 'A' && wordArr[si] <= 'Z') {
            isUpper = true;
        }
        if (isUpper) {
            for (int i = si + 1; i <= ei; i++) {
                if (wordArr[i] >= 'a' && wordArr[i] <= 'z') {
                    return 0;
                }
            }
        } else {
            for (int i = si + 1; i <= ei; i++) {
                if (wordArr[i] >= 'A' && wordArr[i] <= 'Z') {
                    return 0;
                }
            }
        }
        return isUpper ? 2 : 1;
    }
}
