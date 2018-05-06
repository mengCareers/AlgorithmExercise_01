/* 422. Valid Word Square
 * Thought Process:
 A word square is valid when the kth row and column read the exact same string.
 So for each row, we read column correspondingly, and check if they read the same.
 If not, return false.
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
        List<String> words = Arrays.asList(new String[]{"abcd", "bnrt", "crmy", "dtye"});
        boolean isValid = validWordSquare(words);
        System.out.println("isValid : " + isValid);
    }

    public static boolean validWordSquare(List<String> words) {
        int k = 0;
        for (String word : words) {
            if (!word.equals(columnRead(k, words))) {
                return false;
            }
            k++;
        }
        return true;
    }

    private static String columnRead(int k, List<String> words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (k >= word.length()) {
                continue;
            }
            sb.append(word.charAt(k));
        }
        return sb.toString();
    }
}
