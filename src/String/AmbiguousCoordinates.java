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
 */
package String;

import java.util.List;

/**
 *
 * @author xinrong
 */
public class AmbiguousCoordinates {

    public List<String> ambiguousCoordinates(String S) {
        
    }
    
    private void util(String s, String prefix, int i, ) {
        // , . ' ' next
        // for nums[i]              e.g. (..4)5
        // concatenate to prefix            45
        // , nums[i]                        4,5
        // . nums[i]                        4.5
        
    }
}
