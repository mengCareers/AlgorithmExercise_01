/* Also named Max Task Load
 * Thought Process:
 * 
 */
package Sorting;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class MaximumNumberofOverlappingIntervals {

    public static void main(String[] args) {
        int[] start = {1};
        int[] end = {7};
        int ans = maxOverlapIntervalCount(start, end);
        System.out.println(ans);
    }

    /**
     *
     * @param start Sorted Necessary
     * @param end Sorted Necessary
     * @return
     */
    public static int maxOverlapIntervalCount(int[] start, int[] end) {
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        int cnt = 0;
        int maxCnt = 0;
        while (i != start.length && j != end.length) {
            if (start[i] < end[j]) {
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
                i++;
            } else {
                cnt--;
                j++;
            }
        }
        return maxCnt;
    }
}
