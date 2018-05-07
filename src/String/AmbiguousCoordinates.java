/* 816. Ambiguous Coordinates
We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  
Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  
Return a list of strings representing all possibilities for what our original coordinates could have been.
Example 1:
Input: "(123)"
Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * Thought Process:
 * When can't we add ','
 after 0
 * When can we add '.'
 * Get :
We split the whole String by "," (its position represented by split) into left, right, and add "." to each part by the utility method addPeriod().
 */
package String;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class AmbiguousCoordinates {

    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        for (int split = 2; split < s.length() - 1; split++) {
            for (String left : addPeriod(s, 1, split)) {
                for (String right : addPeriod(s, split, s.length() - 1)) {
                    result.add("(" + left + ", " + right + ")");
                }
            }
        }
        return result;
    }

    private List<String> addPeriod(String s, int i, int j) {
        List<String> result = new ArrayList<>();
        for (int d = 1; i + d <= j; d++) {
            String left = s.substring(i, i + d);
            String right = s.substring(i + d, j);
            if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
                result.add(left + (i + d < j ? "." : "") + right);
            }
        }
        return result;
    }
}
