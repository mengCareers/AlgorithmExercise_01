/*
 * Thought Process:
 * 
 */
package Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class InsertNewIntervalintoSortedArray {

    public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size()) {
            Interval cur = intervals.get(i);
            if (cur.en < newInterval.st) {
                res.add(cur);
            } else if (cur.en >= newInterval.st || cur.st <= newInterval.en) {
                newInterval = new Interval(Math.min(cur.st, newInterval.st), Math.max(cur.en, newInterval.en));
            } else if (newInterval.en < cur.st) {
                res.add(newInterval);
                newInterval = cur;
            }
            i++;
        }
        res.add(newInterval);
        return res;
    }

    static class Interval {

        int st;
        int en;

        private Interval(int st, int en) {
            this.st = st;
            this.en = en;
        }

    }

}
