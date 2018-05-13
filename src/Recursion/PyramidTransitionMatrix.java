/* 756.Pyramid Transition Matrix
If (A, B, C) is an allowed triple. 
For every block of C we place not in the bottow row,
we place it on top of a left block of A and right block of B
input : bottom, bottom row represented as a single string 
        allowed, list of allowed triples, each triple represented as a string of length 3
output: true if we can build the pyramid all the way to the top
* Thought Process:
 * save the transition from down left right to up
 * backtracking
GET: 
+ We build Map downToUps first.
For the pyramid as below, bottom is XYZ, 
we define [down] XY with [top] D, [down] YZ with [top] E.
    A
   / \
  D   E
 / \ / \
X   Y   Z
+ recursionUtil( ) recursively try each possible down as bottom, if one of them can construct pyramid until the top, we return true :
+ How do we get all possible downs? constructDowns( ) uses Backtracking technique to construct a list of possible downs.

*/
package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class PyramidTransitionMatrix {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> downToUps = new HashMap<>();
        for (String allow : allowed) {
            String mkey = allow.substring(0, 2);
            if (!downToUps.containsKey(mkey)) {
                downToUps.put(mkey, new ArrayList<>());
            }
            downToUps.get(mkey).add(allow.substring(2));
        }
        return recursionUtil(bottom, downToUps);
    }

    private boolean recursionUtil(String bottom, Map<String, List<String>> downToUps) {
        if (bottom.length() == 1) {
            return true;
        }
        for (int downStart = 0; downStart < bottom.length() - 1; downStart++) {
            if (!downToUps.containsKey(bottom.substring(downStart, downStart + 2))) {
                return false;
            }
        }
        List<String> downs = new ArrayList<>();
        constructDowns(downs, 0, bottom, downToUps, new StringBuilder());
        for (String down : downs) {
            if (recursionUtil(down, downToUps)) {
                return true;
            }
        }
        return false;
    }

    private void constructDowns(List<String> downs, int downStart, String bottom, Map<String, List<String>> downToUps, StringBuilder sbDown) {
        if (downStart == bottom.length() - 1) {
            downs.add(sbDown.toString());
            return;
        }
        String curDown = bottom.substring(downStart, downStart + 2);
        for (String up : downToUps.get(curDown)) {
            sbDown.append(up);
            constructDowns(downs, downStart + 1, bottom, downToUps, sbDown);
            sbDown.deleteCharAt(sbDown.length() - 1);
        }
    }
}
