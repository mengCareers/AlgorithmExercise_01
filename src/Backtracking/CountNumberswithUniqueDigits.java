/* 357.Count Numbers with Unique Digits
input : n digits
output: # of numbers with unique digits

 * Thought Process: 1st not zero
0012, n = 4, ok
so 
        while (p < res.length && res[p] == 0)
            p++;
 */
package Backtracking;

/**
 *
 * @author xinrong
 */
public class CountNumberswithUniqueDigits {
    
    public static void main(String[] args) {
        int n = new CountNumberswithUniqueDigits().countNumbersWithUniqueDigits(3);
        System.out.println(n);
    }
    
    int[] cnt;
    // m = 10, n = n
    public int countNumbersWithUniqueDigits(int n) {
        cnt = new int[1];
        cnt[0] = 0;
        int[] res = new int[n];
        // int m = 10;
        int cptr = 0;
        util(res, cptr);
        int q = (int) Math.pow(10, n);
        return cnt[0];
    }

    void util(int[] res, int cptr) {
        if (cptr == res.length) {
            cnt[0]++;
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (isvalid(res, i, cptr)) {
                res[cptr] = i;
                util(res, cptr + 1);
            }
        }
    }
    
    boolean isvalid(int[] res, int i, int cptr) {
        int p = 0;
        while (p < res.length && res[p] == 0)
            p++;
        for (; p < cptr; p++) {
            if (i == res[p])
                return false;
        }
        return true;
    }
}
