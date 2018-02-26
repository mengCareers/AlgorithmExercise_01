/*
input : s, wordDict
output: s added spaces such that each word is in dict

s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is ["cats and dog", "cat sand dog"]
 * Thought Process:
e.g.
    c atsanddog
    if c is, ..
    else ca tsanddog 
 * Get :
for(String word: wordDict) {
            if (s.startsWith(word)) {
Quicker when word too long
 */
package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class WordBreakII {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> list = new WordBreakII().wordBreak(s, wordDict);
        System.out.println(list);
    }

    Set<String> dict;

    public List<String> wordBreak(String s, List<String> wordDict) {

        dict = new HashSet<>();
        for (String w : wordDict) {
            dict.add(w);
        }

        return utilLoopDict(s);
    }
    
    private List<String> utilLoopDict (String s) {
        ArrayList<String> cur = new ArrayList<>();
        for (String word : dict) {
            if (s.startsWith(word)) {
                if (word.length() == s.length()) 
                    cur.add(word);
                else {
                    String sub2 = s.substring(word.length());
                    List<String> list = utilLoopDict(sub2);
                    if (list != null) {
                        for (String it : list) {
                            cur.add(word + " " + it);
                        }
                    }
                }
            }
        }
        return cur;
    }

    List<String> utilLoopS(String s) {
        List<String> cur = new ArrayList<String>();
        for (int i = 1; i <= s.length(); i++) {
            String sub1 = s.substring(0, i);

            if (dict.contains(sub1)) {
                if (i == s.length()) {
                    cur.add(sub1);
                } else {
                    String sub2 = s.substring(i);
                    List<String> list = utilLoopS(sub2);
                    if (list != null) {
                        for (String t : list) {
                            cur.add(sub1 + " " + t);
                        }
                    }

                }

            }
        }
        return cur;
    }
}
