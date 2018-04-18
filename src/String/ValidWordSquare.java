/* 422. Valid Word Square
 * Thought Process:
 * 
 */
package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class ValidWordSquare {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(new String[]{"abcd","bnrt","crmy","dtye"});
        boolean isValid = validWordSquare(words);
        System.out.println("isValid : " + isValid);
    }

    public static boolean validWordSquare(List<String> words) {
        String word = "";
        String nextPrefix = "";
        for (int i = 0; i < words.size(); i++) {
            word = words.get(i);
            if (i - 1 >= 0 && word.length() > words.get(i - 1).length()) {
                return false;
            }
            if (!nextPrefix.isEmpty() && !word.startsWith(nextPrefix)) {
                return false;
            }
            String prefix = "";
            for (int j = 0; j <= i; j++) {
                if (i + 1 < words.get(j).length()) {
                    prefix += words.get(j).charAt(i + 1);
                } 
            }
            System.out.println("prefix : " + prefix);
            nextPrefix = prefix;
        }
        return true;
    }
}
