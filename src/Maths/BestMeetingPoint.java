package Maths;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 296. Best Meeting Point
input : grid[][] consists of 0 or 1 (home)
output: (x,y) enable minimize total manhanttan distance from 1s to (x,y)
 * Thought Process:
 * Get: (medianRow, medianCol) can minimize total manhanttan distance
 */

/**
 *
 * @author xinrong
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        int r = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int c = cols.get(cols.size() / 2);
        return getDist(rows, r) + getDist(cols, c);
    }    
    int getDist(List<Integer> ps, int p) {
        int dist = 0;
        for (int i : ps)
            dist += Math.abs(i - p);
        return dist;
    }
}
