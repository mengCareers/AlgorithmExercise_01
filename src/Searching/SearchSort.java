/*
 * Thought Process:
 * 
 */
package Searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class SearchSort {

    public boolean isRoatated(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        s2 += s1;
        if (!s2.contains(s1)) {
            return false;
        }
        return true;
    }

    public String reverseSentence(String str) {
        if (str == null || str.length() == 1) {
            return str;
        }
        char[] arr = new char[str.length()];
        reverse(arr, 0, arr.length - 1);
        int wordbegin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, wordbegin, i - 1);
                wordbegin = i + 1;
            }
        }
        reverse(arr, wordbegin, arr.length - 1);
        return arr.toString();
    }

    private void reverse(char[] arr, int s, int e) {
        while (s < e) {
            char t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++;
            e--;
        }
    }

    public int equilibriumPoint(int[] arr) {
        int sum = 0;
        int leftsum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            leftsum += arr[i];
            if (sum == leftsum) {
                return i + 1;
            }
        }
        return -1;
    }

    public void checkIfTwoSumEqualRestNoDup(int[] arr) {
        int sum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            System.out.println("Not Found");
            return;
        }
        sum /= 2; // 
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int v = sum - arr[i];
            if (set.contains(v)) {
                System.out.println("Found Values = " + arr[i] + ", " + v);
                return;
            }
            if (!set.contains(v)) {
                set.add(arr[i]);
            }
        }
        System.out.println("Not Found");
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] map = new int[256];
        for (char c : s1.toCharArray()) {
            map[c]++;
        }
        for (char c : s2.toCharArray()) {
            map[c]--;
        }
        for (int i : map) {
            if (i != 0)
                return false;
        }
        return true;
    }
    
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SearchSort inst = new SearchSort();
        int[] arr = {6, 3, 4};

//        int ans = inst.equilibriumPoint(arr);        
//        System.out.println(ans);
        inst.checkIfTwoSumEqualRestNoDup(arr);
    }

}
