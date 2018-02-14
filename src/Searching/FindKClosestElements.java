/* 658. Find K Closest Elements
input : arr, k, x
output: k closest elements to x in arr
        smaller first, ascending
 * Thought Process:
 * Get : Collections.binarySearch
    return     the index of the search key, if it is contained in the list; 
    otherwise, (-(insertion point) - 1)
    insertion point : the index of the first element greater than the key, 
                      or list.size() if all elements in the list are less than the specified key.
 */
package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class FindKClosestElements {
    
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,3,4,6,8,8};
        List<Integer> res = new FindKClosestElements().findClosestElements(arr, 6, 1);
        System.out.println(res);
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        int idx = Arrays.binarySearch(arr, x);
        if (idx < 0) // not found
            idx = -(idx + 1); // idx = insertion point
        int i = idx - 1, j = idx;
        while (k-- > 0) {
            if ( i < 0 || (j < arr.length && Math.abs(arr[i] - x) > Math.abs(arr[j] - x)) )
                j++;
            else
                i--;
        }
        
        for (int p = i + 1; p < j; p++) {
            res.add(arr[p]);
        }
        return res;
    }

    public List<Integer> findClosestElementsWrong(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null) {
            return res;
        }
        int len = arr.length;
        if (len == 0) {
            return res;
        }
        if (x <= arr[0]) {
            int j = 0;
            for (int i = 0; i < k; i++) {
                res.add(arr[j++]);
            }
        }
        if (x >= arr[len - 1]) {
            int j = len - 1;
            for (int i = 0; i < k; i++) {
                res.add(arr[j--]);
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == x) {
                int kstart = i - k / 2;
                for (int t = 0; t < k; t++) {
                    res.add(arr[kstart++]);
                }
            } else if (arr[i] > x && arr[i - 1] < x) {
                if (k % 2 == 0) {
                    int kstart = i - k / 2;
                    for (int t = 0; t < k; t++) {
                        res.add(arr[kstart++]);
                    }
                } else {
                    int kstart = i - k / 2 - 1;
                    for (int t = 0; t < k; t++) {
                        res.add(arr[kstart++]);
                    }
                }
            }
        }
        return res;
    }
}
