/*
 * Q: Word Game
 * input : string, int K
 * output:find the substrs of size K with K distinct chars,
 * 	  that is, find the substrs with dif chars
 * e.g. awaglk 4 return wagl aglk
 * TP:
Sliding Window, ptr l & r,
 */
package TwoPtrs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class WordGame {

    public static void main(String[] args) {
        String str = "awaglk";
        int K = 4;
        List<String> ans = new WordGame().wordGame(str, K);
        System.out.println(ans);
    }

    public List<String> wordGame(String str, int k) {
        List<String> res = new ArrayList<String>();
        char[] arr = str.toCharArray();
        int[] map = new int[256];
        int l = 0, r = 0, len = str.length(), cnt = 0;

        while (r < len) {
            while (r - l + 1 <= k && r < len) {
                if (map[arr[r++]]++ == 0) {
                    cnt++;
                }
            }
            if (cnt == k) {
                res.add(str.substring(l, r));
                if (--map[arr[l++]] == 0) {
                    cnt--;
                }
            }
            while (cnt != r - l) {
                if (--map[arr[l++]] == 0) {
                    cnt--;
                }
            }
        }

        return res;
    }
}
