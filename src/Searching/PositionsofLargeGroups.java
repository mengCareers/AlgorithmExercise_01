/* 830. Positions of Large Groups
input : S, consecutive groups of the same character
        e.g. abbxxxxzyy has the groups a, bb, xxxx, z, yy
output : starting and ending positions of every large group
        large group if it has 3 or more charactes
 * Thought Process:
 * 
 */
package Searching;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class PositionsofLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> positions = new ArrayList<>();
        int i = 0;
        while (i < S.length()) {
            char ch = S.charAt(i);
            int j = i + 1;
            while (j < S.length()) {
                if (S.charAt(j) != ch) {
                    break;
                }
                j++;
            }
            j--;
            if (j - i >= 2) {
                List<Integer> position = new ArrayList<>();
                position.add(i);
                position.add(j);
                positions.add(position);
            }
            i = j + 1;
        }
        return positions;
    }
}
