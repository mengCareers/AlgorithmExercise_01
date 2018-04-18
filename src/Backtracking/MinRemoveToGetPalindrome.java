/*
 * Thought Process:
 * 
 */
package Backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class MinRemoveToGetPalindrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int ans = getPalin(str);
        System.out.println(ans);
    }

    private static int cnt = 0;
    private static Set<String> set = new HashSet<>();

    public static int getPalin(String str) {
        recurUtil(str, str, "");
        return cnt;
    }

    private static void recurUtil(String str, String curRes, String removedStr) {
        if (curRes.length() == 0) {
            return;
        }
        if (isPalin(curRes)) {
            if (!set.add(removedStr)) {
                return;
            }
            cnt++;
        }

        int i = 0;
        while (i < curRes.length()) {
            removedStr += curRes.charAt(i);
            recurUtil(str, curRes.substring(0, i) + curRes.substring(i + 1), removedStr);
            i++;
        }
    }

    private static boolean isPalin(String str) {
        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
