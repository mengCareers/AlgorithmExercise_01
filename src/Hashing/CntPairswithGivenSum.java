package Hashing;


import java.util.Arrays;

/* find # of pairs in arr[] whose sum = sum
 * Thought Process:
 * pairs of two sum in arr
   two ptrs
 */

/**
 *
 * @author xinrong
 */
public class CntPairswithGivenSum {
    public static void main(String[] args) {
        int[] arr = {-1, 1, 5, 7};
        int ans = new CntPairswithGivenSum().cntPairs(arr, 6);
        System.out.println(ans);
    }
    public int cntPairs(int[] arr, int sum) {
        Arrays.sort(arr);
        int lo = 0, hi = arr.length - 1;
        int cnt = 0;
        while (lo < hi) {
            int tmp = arr[lo] + arr[hi];
            if (tmp == sum) {
                cnt++;
                lo++;
                hi--;
            }
            else if (tmp < sum) 
                lo++;
            else 
                hi--;
        }
        return cnt;
    }
}
