/* 391.Perfect Rectangle
Given N axis-aligned rectangles where N > 0
determine if they all together form an exact cover of a rectangular region
Each rectangle is represented as a bottom-left point and top-right point
e.g. a unit square is represented as [1, 1, 2, 2] (coordinate of bottom-left point is (1,1) and top-right point is (2, 2)
 * Get:
The right answer must satisfy conditions : 
SlargeRect = sum(SsmallRect)
# of points should be even, # of four cornor points should be one
 * 4 edges should be in set at last (x1, y1) (x1, y2) (x2, y1) (x2, y2)
 * x1, y1 should be mins
 * x2, y1 should be mins
 * SlargeRect = sum(SsmallRect)
 */
package Maths;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class PerfectRectangle {

    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        int area = 0;
        for (int[] rect : rectangles) {
            x1 = Math.min(x1, rect[0]);
            y1 = Math.min(y1, rect[1]);
            x2 = Math.max(x2, rect[2]);
            y2 = Math.max(y2, rect[3]);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            String s1 = rect[0] + " " + rect[1]; // x1 y1
            String s2 = rect[0] + " " + rect[3]; // x1 y2
            String s3 = rect[2] + " " + rect[1]; // x2 y1
            String s4 = rect[2] + " " + rect[3]; // x2 y2
            if (!set.add(s1)) {
                set.remove(s1);
            }
            if (!set.add(s2)) {
                set.remove(s2);
            }
            if (!set.add(s3)) {
                set.remove(s3);
            }
            if (!set.add(s4)) {
                set.remove(s4);
            }
        }
        if (!set.contains(x1 + " " + y1)
                || !set.contains(x1 + " " + y2)
                || !set.contains(x2 + " " + y1)
                || !set.contains(x2 + " " + y2)
                || set.size() != 4) {
            return false;
        }
        return area == (x2 - x1) * (y2 - y1);
    }
}
