/* 447.Number of Boomerangs
input : points[][]
output: # of Boomerangs - (i, j, k) such that the distance between i and j equals the distance between i and k
 * Thought Process:
 * Exhaustie search
 */
package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author xinrong
 */
public class NumberofBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int dist = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                dist = getDist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int val : map.values()) {
                res += val * (val - 1);
            }
            map.clear();
        }

        return res;
    }

    int getDist(int[] p1, int[] p2) {
        int xd = p1[0] - p2[0];
        int yd = p1[1] - p2[1];
        return xd * xd + yd * yd;
    }
}
