/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class IsSubsetArray {
    // Brute Force
    public boolean isSubset1(int[] arr1, int[] arr2) {
        for (int i : arr2) {
            boolean isSub = false;
            for (int j : arr1) {
                if (i == j) isSub = true;
            }
            if (!isSub) return false;
        }
        return true;
    }
    // Brute Force with Binary Search
    public boolean isSubset2(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        for (int i : arr2) {
            boolean isSub = false;
            // Binary Search i in arr1
            int lo = 0, hi = arr1.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (i < arr1[mid]) hi = mid - 1;
                else if (i > arr1[mid]) lo = mid + 1;
                else {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) return false;
        }
        return true;
    }
    // Sorting and Merging
    public boolean isSubset3(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int len1 = arr1.length, len2 = arr2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                return false;
            } else {
                i++;
            }
        }
        if (j < len2) return false;
        return true;
    }
    // Hashing allowing duplicates
    public boolean isSubset4(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        /* assumed distinct
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int j : arr2) {
            if (!set.contains(j)) return false;
        }
        return true;
        */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int j : arr2) {
            if (!map.containsKey(j)) return false;
            map.put(j, map.get(j) - 1);
        }
        for (int k : map.keySet()) {
            if (map.get(k) < 0 ) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1, 2};
        boolean ans = new IsSubsetArray().isSubset4(arr1, arr2);
        System.out.println(ans);
    }
}
