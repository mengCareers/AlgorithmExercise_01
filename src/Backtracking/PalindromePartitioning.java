/* 131.Palindrome Partitioning
input : s
output: List<List<String>>
For example, given s = "aab",
Return
[
  ["aa","b"],
  ["a","a","b"]
]
 * Thought Process:
 * 
 */
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        List<List<String>> res = new PalindromePartitioning().partition("aab");
        System.out.println(res);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> res =  util(s);
        for (String r : res) {
            String[] rs = r.split(" ");
            List<String> cur = Arrays.asList(rs);
            result.add(cur);
        }
        return result;
    }

    List<String> util(String s) {
        List<String> cur = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            if (isPalindrome(s1)) {
                if (i == s.length()) {
                    cur.add(s1);
                } else {
                    String s2 = s.substring(s1.length());
                    List<String> list = util(s2);
                    if (list != null) {
                        for (String it : list) {
                            cur.add(s1 + " " + it);
                        }
                    }
                }
            }
        }
        return cur;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
