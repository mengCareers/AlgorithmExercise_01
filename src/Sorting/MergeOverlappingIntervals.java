/*
 * Thought Process:
 * 
 */
package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(0, 0));
        List<Interval> res = merge(intervals);
        for (Interval interval : res) {
            System.out.println("[" + interval.start + " " + interval.end + "]");
        }
    }

    static class Interval {

        int start;
        int end;

        private Interval(int st, int en) {
            this.start = st;
            this.end = en;
        }

    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = res.remove(res.size() - 1);
            Interval cur = intervals.get(i);
            if (prev.end >= cur.start) {
                // merge
                Interval merged = new Interval(Math.min(prev.start, cur.start), Math.max(prev.end, cur.end));
                res.add(merged);
            } else {
                res.add(prev);
                res.add(cur);
            }
        }
        return res;
    }
}
