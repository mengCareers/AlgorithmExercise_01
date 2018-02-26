/* 60.Permutation Sequence
input : n k
output: kth permutation sequence of 1..n
e.g. n = 3
123
132
213
231
312
321
 * Thought Process:
 * 
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class PermutationSequence {
    
    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        String res = new PermutationSequence().getPermutation(n, k);
        System.out.println(res);
    }

    public String getPermutation(int n, int k) {
        int[] v = new int[n];
        for (int i = 1; i <= n; i++) {
            v[i - 1] = i;
        }
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        getSeq(v, res, "", used);
        System.out.println(res);
        return res.get(k - 1);
    }

    private void getSeq(int[] v, List<String> res, String cur, boolean[] used) {
        if (cur.length() == v.length) {
            res.add(new String(cur));
            return;
        }
        for (int i = 0; i < v.length; i++) {
            if (used[i] == true)
                continue;
            used[i] = true;
            cur += String.valueOf(v[i]);
            getSeq(v, res, cur, used);
            used[i] = false;
            cur = cur.substring(0, cur.length() - 1);
        }
    }
}
