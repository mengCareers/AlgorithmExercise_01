/* 757. Set Intersection Size At Least Two
input : inclusive intervals
output: find min size set S such taht all intervals have at least 2 nums in S
Get : what if at least 1 ?
    - sort. the last interval [s, e], 
            other interval start point <= s,
            better to choose s as start.
            So repeatedly take s in S and remove all intervals containing s.
      what if at least 2?
    - todo starts at 2
            as we identify points in S, substract from todo[]
      
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class SetIntersectionSzAtLeastTwo {
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}, {3, 5}, {3, 4}, {4, 5}};
        int[] ans = new SetIntersectionSzAtLeastTwo().getInterval(intervals);
        for (int i : ans)
            System.out.print(i + " ");
    }
    
    public int[] getInterval(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        int t = intervals.length;
        Set<Integer> set = new HashSet<>();
        int[] todo = new int[intervals.length];
        Arrays.fill(todo, 2);
        while((--t) >= 0) {
            int s = intervals[t][0];
            int e = intervals[t][1];
            int m = todo[t];
            for (int p = s; p < s + m; p++) {
                for (int i = 0; i <= t; i++) {
                    if (todo[i] > 0 && p <= intervals[i][1])
                        todo[i]--;
                }
                set.add(p);
            }
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : set) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return new int[ ]{min, max};
    }
    
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        int t = intervals.length, ans = 0;
        int[] todo = new int[intervals.length];
        Arrays.fill(todo, 2);
        while((--t) >= 0) {
            int s = intervals[t][0];
            int e = intervals[t][1];
            int m = todo[t];
            for (int p = s; p < s + m; p++) {
                for (int i = 0; i <= t; i++) {
                    if (todo[i] > 0 && p <= intervals[i][1])
                        todo[i]--;
                }
                ans++;
            }
        }
        return ans;
    }
}
