package Sorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 616. Add Bold Tag in String
 * Thought Process:
If a substring of s equals to a word in dict, we wrap it by bold tags following some merging rules. 
=> So the key is to merge the substrings.
=> That smells like **Merge Intervals** as below:
https://leetcode.com/problems/merge-intervals/description/
=> We build Interval class with substrings' start and end indices. Before the merging process, we sort the intervals by start indices. In order to combine consecutive intervals, we need to modify the merging condition properly.
=> Nerver ignore the corner cases.
=> **Accepted**
 * 
 */
/**
 *
 * @author xinrong
 */
public class AddBoldTaginString {

    public static void main(String[] args) {
        String s = "aaabbcc";
        String[] dict = {"aaa", "aab", "bc"};
        String ans = new AddBoldTaginString().addBoldTag(s, dict);
        System.out.println(ans);
    }

    class Interval {

        int st;
        int en;

        public Interval(int st, int en) {
            this.st = st;
            this.en = en;
        }
    }

    public String addBoldTag(String s, String[] dict) {

        if (dict == null || dict.length == 0) {
            return s;
        }

        List<Interval> intervals = new ArrayList<>();
        for (String word : dict) {
            int len = word.length();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == word.charAt(0)) {
                    if (i + len <= s.length() && s.substring(i, i + len).equals(word)) {
                        intervals.add(new Interval(i, i + len - 1));
                    }
                }
            }
        }
        if (intervals.size() == 0) {
            return s;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.st == i2.st) {
                    return i1.en - i2.en;
                }
                return i1.st - i2.st;
            }
        });

        List<Interval> merged = new ArrayList<>();
        merged.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            Interval prev = merged.remove(merged.size() - 1);
            if (prev.en >= cur.st - 1) {
                Interval nv = new Interval(Math.min(prev.st, cur.st), Math.max(prev.en, cur.en));
                merged.add(nv);
            } else {
                merged.add(prev);
                merged.add(cur);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int mi = 0;
        while (i < s.length()) {
            while (i < merged.get(mi).st) {
                sb.append(s.charAt(i));
                i++;
            }
            sb.append("<b>");
            sb.append(s.substring(merged.get(mi).st, merged.get(mi).en + 1));
            sb.append("</b>");
            i = merged.get(mi).en + 1;
            mi++;
            if (mi == merged.size()) {
                break;
            }
        }
        while (i < s.length()) {
            sb.append(s.charAt(i));
            i++;
        }

        return sb.toString();

    }
}
