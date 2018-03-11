/*
 * Thought Process:
 * 
 */
package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class TwoSum {

    public boolean twoSumSortedRotated(int[] arr, int target) {
        int n = arr.length;
        // e.g. 8 9 1 5 7
        // to find 9
        int i = 0;
        for (; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                break;
        }
        // to find minimum' idx s
        int s = (i + 1) % n;
        // to find maximum' idx b
        int b = i;
        while (s != b) {
            if (arr[s] + arr[b] == target)
                return true;
            else if (arr[s] + arr[b] < target) {
                s = (s + 1) % n;
            }
            else {
                b = (b - 1 + n) % n;
            }
        }
        return false;
    }
    
    /**
     *
     * @param arr
     * @param target
     * @return Indices
     */
    public List<List<Integer>> twoSumDup1(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (map.keySet().contains(target - arr[i])) {
                List<Integer> tis = map.get(target - arr[i]);
                for (int ti : tis) {
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(ti);
                    result.add(res);
                }
            } else {
                if (map.get(arr[i]) == null) {
                    List<Integer> val = new ArrayList<>();
                    map.put(arr[i], val);
                }               
                map.get(arr[i]).add(i);                
            }
        }
        
        return result;
    }

    /**
     *
     * @param arr
     * @param target
     * @return Value pairs
     */
    public List<List<Integer>> twoSumDup2(int[] arr, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1; // !!!!!!!!!
        while (i < j) {
            if (arr[i] + arr[j] > target) {
                j--;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else {
                List<Integer> res = new ArrayList<>();
                res.add(arr[i]);
                res.add(arr[j]);
                result.add(res);
                i++;
                j--;
                while (i < j && arr[i] == arr[i + 1]) {
                    i++;
                }
                while (i < j && arr[j] == arr[j - 1]) {
                    j--;
                }
            }
        }
        
        return result;
        
    }

    /**
     *
     * @param arr
     * @param target
     * @return Indices
     */
    public List<List<Integer>> twoSumWODup(int[] arr, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (map.keySet().contains(target - arr[i])) {
                int ti = map.get(target - arr[i]);
                List<Integer> res = new ArrayList<>();
                res.add(i);
                res.add(ti);
                result.add(res);
            } else {
                map.put(arr[i], i);
            }
        }
        
        return result;
        
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, -1};
        int target = 0;
        boolean result = new TwoSum().twoSumSortedRotated(arr, target);
        
        System.out.println(result);
        
    }
    
}
