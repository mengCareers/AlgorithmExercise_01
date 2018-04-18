/*320. Generalized Abbreviation
 * Thought Process:
 * At each state, we can EITHER pick the char after attach cnt OR skip it & increase cnt
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class GeneralizedAbbreviation {

    /*
    for each pos, we can 
        either pick the char after attach cnt
        or     skip the char and increase cnt
     */
    public List<String> generateAbbreviations(String word) {
        List<String> allRes = new ArrayList<>();
        backtrackUtil(word, allRes, "", 0, 0);
        return allRes;
    }

    private static void backtrackUtil(String word, List<String> allRes, String curRes, int pos, int cnt) {
        if (pos == word.length()) {
            if (cnt > 0) {
                curRes += cnt;
            }
            allRes.add(curRes);
            return;
        }
        // Pick it
        backtrackUtil(word, allRes, curRes + (cnt > 0 ? cnt : "") + word.charAt(pos), pos + 1, 0);
        // Skit it
        backtrackUtil(word, allRes, curRes, pos + 1, cnt + 1);
    }
}
