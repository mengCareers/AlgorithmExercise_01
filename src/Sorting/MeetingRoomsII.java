package Sorting;


import java.util.Arrays;

/* 253. Meeting Rooms II
input : Interval[] intervals
output: min # of room needed
 * Thought Process:
sort them
i in intervals
0   +
if conflict +
sort by start time
 * Get:
Sort starts and ends,
compare starts[i++] with ends[eptr],
    if conflict, res++
    else eptr++
Why? To minimize the # of room, we want the idle shortest, min(idle) = starts[i] < ends[eptr] 
 * 
 */

/**
 *
 * @author xinrong
 */
public class MeetingRoomsII {
    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int eptr = 0;
        int res = 0;
        for (int i = 0; i < len; i++) { // sptr
            if (starts[i] < ends[eptr])
                res++;
            else
                eptr++;
        }
        return res;
    }
}
