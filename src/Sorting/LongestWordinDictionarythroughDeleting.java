package Sorting;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 524.Longest Word in Dictionary through Deleting
input : s, d
output: str - the longest str in d that can be formed by deleting some chars of s
if there are more than one possible results, return the longest word with the smallest lexicographical order
if no possible results, return ""
 * Thought Process:
- what does it mean by 'deleting some chars of s'?
str is subsequence of s
- that is, we get all s, order by len, see if in d
  or we try each word of d, order by len, see if it in s
- How do we check if str is subseq of s?
  a b c
      i
  a d d b d c
            j
 * Get:
- subsequence > substring
- If we define customize Comparator, we should consider what if the compare condition is equal.
- How to make sure the smallest lexicographical order? if len equal, sort by a.compareTo(b)
 */

/**
 *
 * @author xinrong
 */
public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.length() != a.length() ? (b.length() - a.length()) : a.compareTo(b); 
            }       
        });
        for (String str : d) {
            if (isSub(str, s))
                return str;
        }
        return "";
    }    
    boolean isSub(String str, String s) {
        int i = 0, j = 0;
        while (i < str.length() && j < s.length()) {
            if (str.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            }
            else
                j++;
        }
        if (i == str.length())
            return true;
        return false;
    }
}
