package Sorting;


import java.util.Arrays;

/* 274. H-Index
input : arr
output: h such that exact h elements >= h
 * Thought Process:
max(h) = len
 * Using countSort
e.g. 3 0 6 5 1
cnt[]0 1 2 3 4 5 
     1 1   1   2
for element i, put in cnt[arr[i]]
if arr[i] >= len, put in cnt[len]
loop from end of cnt,
if total cnt >= idx,
return idx
 * 
 */

/**
 *
 * @author xinrong
 */
public class HIndex {
    public static void main(String[] args) {
        int[] arr = {0};
        int h = new HIndex().hIndex(arr);
        System.out.println(h);
    }
    public int hIndex(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int len = arr.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int val = arr[i];
            if (val < len)
                cnt[val]++;
            else
                cnt[len]++;
        }
        int sum = 0;
        for (int i = len; i > 0; i--) {
            sum += cnt[i];
            if (sum >= i)
                return i;
        }
        return 0;       

    }    
}
