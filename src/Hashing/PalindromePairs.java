/*
336. Palindrome Pairs
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
return [[0, 1], [1, 0], [2, 4], [3, 2]]
 * Thought Process:
for wi in word, concacatenate with rest words one by one, if palindrome, add to res
 * memorization
palinPairs(i, j)
 * GET:
When we try the Exhaustive Search method, we do duplicate calculations in isPalindrome().

Let’s think about the structure of a Palindrome Pair.
if words[j] = reverse ( any substring of words[i] ), and the rest part of words[i] is a palindrome, a palindome pair is constructed using words[i] and words[j]

Thus,
=> for each word in words, we add two pointers L = 0, and R = 0. R moves towards end step by step, L starts to move after R reaches end.
=> for each substring s(L…R), we check if words[j] = reverse(s(L…R)) exists using map
if exists,
L = 0 and s(R…end) is Palindrome, words[i] and words[j] are palindrome pairs.
or
R = 0 and s(0…R) is Palindrome, words[j] and words[i] are palindrome pairs.
 * 
 */
package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class PalindromePairs {

    public static void main(String[] args) {
        PalindromePairs inst = new PalindromePairs();
        String[] words = {"lls", "s"};
        List<List<Integer>> res = inst.palindromePairs(words);
        System.out.println(res);
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private static boolean isPalindrome(String str) {
        int st = 0, en = str.length() - 1;
        while (st < en) {
            if (str.charAt(st) != str.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int m = 0; m <= words[i].length(); m++) {
                String pre = words[i].substring(0, m);
                String post = words[i].substring(m);
                if (isPalindrome(pre)) {
                    Integer j = map.get(reverse(post));
                    if (j != null && j != i) {
                        res.add(Arrays.asList(j, i));
                    }
                }
                if (post.length() > 0 && isPalindrome(post)) {
                    Integer j = map.get(reverse(pre));
                    if (j != null && j != i) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> palindromePairs_TwoPointers(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            int l = 0, r = 0;
            while (l <= r) {
                String sub = words[i].substring(l, r);
                Integer j = map.get(new StringBuilder(sub).reverse().toString());
                if (j != null && j != i) {
                    if (l == 0) {
                        if (isPalindrome(words[i].substring(r))) {
                            List<Integer> indices = new ArrayList<>();
                            indices.add(i);
                            indices.add(j);
                            res.add(indices);
                        }
                    } else {
                        if (isPalindrome(words[i].substring(0, l))) {
                            List<Integer> indices = new ArrayList<>();
                            indices.add(j);
                            indices.add(i);
                            res.add(indices);
                        }
                    }
                }
                if (r < words[i].length()) {
                    r++;
                } else {
                    l++;
                }

            }
        }

        return res;
    }

    /* Exhaustive Search
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j != i) {
                    String ns = words[i] + words[j];
                    if (isPalindrome(ns)) {
                        List<Integer> indices = new ArrayList<>();
                        indices.add(i);
                        indices.add(j);
                        res.add(indices);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        int st = 0, en = str.length() - 1;
        while (st < en) {
            if (str.charAt(st) != str.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
     */
}
