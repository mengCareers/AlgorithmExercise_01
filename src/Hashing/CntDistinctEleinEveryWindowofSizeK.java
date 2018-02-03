package Hashing;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* arr[], int k
   return # of distinct numbers in all windows of size k
 * Thought Process:
for every window, save # of distinct numbers in res
how ot get # of distinct numbers
since it is sliding, we can use info of previous window
use hash <val, cnt>
map to store eles of curr window
when slide, do with sth
 * 
 */

/**
 *
 * @author xinrong
 */
public class CntDistinctEleinEveryWindowofSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        List<Integer> res = new CntDistinctEleinEveryWindowofSizeK().cntDistinct(arr, 4);
        System.out.println(res);
    }
    public List<Integer> cntDistinct(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
                cnt++;
            } else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        res.add(cnt);
        // traverse through remaining array
        for (int i = k; i < arr.length; i++) {
            // remove 1st ele of previous window, do with sth
            int freq = map.get(arr[i - k]);
            if (freq == 1) {
                map.remove(arr[i - k]);
                cnt--;
            }
            else {
                map.put(arr[i - k], freq - 1);
            }
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
                cnt++;
            } else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            res.add(cnt);
        }
        return res;
    }
}
