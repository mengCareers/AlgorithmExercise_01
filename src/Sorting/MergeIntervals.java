package Sorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 56. Merge Intervals
input : list of intervals
output: list of intervals such that overlapping intervals are merged
 * Thought Process:
- what does it mean by overlapping? s1 <= e2 & s2 <= e1
e.g. [1,3],[2,6],[8,10],[15,18]
sort by start first
loop through list
if meet the overlapping condition
min(s1, s2), max(e1, e2)
 * 
 */

/**
 *
 * @author xinrong
 */
public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> res = new MergeIntervals().merge(intervals);
        for (Interval i : res)
            System.out.println(i.start + ", " + i.end);
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0)
            return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override // upper O
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = res.get(res.size() - 1);
            Interval cur  = intervals.get(i);
            if (prev.start  <= cur.end && cur.start <= prev.end) {
                Interval tmp = new Interval(Math.min(prev.start, cur.start), Math.max(prev.end, cur.end));
                res.remove(prev);
                res.add(tmp);
            }
            else {
                res.add(cur);
            }
        }
        return res;
    }    
    
    static class Interval {
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
}
