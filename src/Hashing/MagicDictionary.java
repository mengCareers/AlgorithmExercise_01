/* 676. Implement Magic Dictionary
 * Thought Process:
 * 
 */
package Hashing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class MagicDictionary {

    List<String> dictionary;

    public MagicDictionary() {
        dictionary = new ArrayList<>();
    }

    public void buildDict(String[] dict) {
        for (String word : dict) {
            dictionary.add(word);
        }
    }

    public boolean search(String word) {
        for (String dict : dictionary) {
            if (dict.length() == word.length()) {
                if (isOneEdit(word, dict)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isOneEdit(String word, String dict) {
        for (int i = 0; i < dict.length(); i++) {
            if (word.charAt(i) != dict.charAt(i)) {
                return word.substring(i + 1).equals(dict.substring(i + 1));
            }
        }
        return false;
    }
}
