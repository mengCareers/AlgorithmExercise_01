package Greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 527.Word Abbreviation
input : 
output: list of minimal abbreviations following rules
rules: apple -> a3e
       if dup, a longer prefix is used instead of the first char
       if len(abbrev) >= len(word), keep the original
 * Thought Process:
abbreviate it by rules
add to set, if can't add(dup), use longer prefix
When will len(abbrev) >= len(word)? abc a1c; ac a0c; if len <= 3
 * Get:
- s.substring(1); 1 is beginIdx, inclusive
- When conflict, they want ALL prefix longer, so we dont use set but to compare by ourselves
- Greedy, when there are many conditions to satisfy. So we choose the shortest abbrevs. If dup, we'll increase
  the length of all dups.
 */

/**
 *
 * @author xinrong
 */
public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> words) {
        int sz = words.size();
        String[] ans = new String[sz];
        int[] prefix = new int[sz];
        for (int i = 0; i < sz; i++)
            ans[i] = abbreviateUtil(words.get(i), 0);
        for (int i = 0; i < sz; i++) {
            while (true) {
                Set<Integer> set = new HashSet<>(); // set of indexes of all dups
                for (int j = i + 1; j < sz; j++) {
                    if (ans[i].equals(ans[j]))
                        set.add(j);
                }
                if (set.isEmpty())
                    break;
                set.add(i);
                for (int t : set)
                    ans[t] = abbreviateUtil(words.get(t), ++prefix[t]);
            }
        }
        return Arrays.asList(ans);
    }
    /*
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("like");
        dict.add("god");
        dict.add("interval");
        dict.add("internal");
        List<String> lst = new WordAbbreviation().wordsAbbreviation(dict);
        System.out.println(lst);
    }
    
    public List<String> wordsAbbreviation(List<String> dict) {
        Set<String> res = new HashSet<>();
        List<String> ans = new ArrayList<>();
        
        for (String s : dict) {
            String str = abbreviateUtil(s);
            while (!res.add(str)) {
                String tmp = abbreviateUtil(s.substring(1));
                tmp = s.charAt(0) + tmp;
                str = tmp;
            }
            ans.add(str);
        }
        return ans;
    }    
    */
    String abbreviateUtil(String s, int i) { // s.substring(0, i) as prefix before
        // what is i ?
        int len = s.length();
        if (len - i <= 3) // str eleminate prefix
            return s;
        // ret 0..i  + len - i - 2
        return s.substring(0, i + 1) + (len - i - 2) + s.charAt(len - 1);
    }
    
}
