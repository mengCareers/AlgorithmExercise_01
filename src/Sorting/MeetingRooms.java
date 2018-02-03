package Sorting;


import java.util.Arrays;
import java.util.Comparator;

/*
 *  Q:252. Meeting Rooms
meeting time intervals [[s1, e1], [s2, e2]] determine if a person can attend all meetings
 *  Thought Process:  
sort by start time, compare 2nd start time with 1st end time
if no conflict, can attend all meetings
*  Get:
comparator if start ==, compare end
 */

/**
 *
 * @author xinrong
 */
public class MeetingRooms {  
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) 
                    return a.start - b.start;
                else 
                    return a.end - b.end;
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            if (i + 1 < intervals.length) {
                if (intervals[i].end > intervals[i + 1].start)
                    return false;
            }
        }
        return true;
    }

    private static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
