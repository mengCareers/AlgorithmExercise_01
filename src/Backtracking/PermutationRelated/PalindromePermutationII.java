/* 267. Palindrome Permutation II
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 * Thought Process:
list all permutations without duplicates
if palindrome, add to list
 * GET :
Exclude the impossible cases FIRST
 * 
 */
package Backtracking.PermutationRelated;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class PalindromePermutationII {

    public static void main(String[] args) {
        List<String> ans = new PalindromePermutationII().generatePalindromes("aabb");
        System.out.println(ans);
    }

    public List<String> generatePalindromes(String s) {

        List<String> allRes = new ArrayList<>();
        char[] chs = s.toCharArray();
        int[] map = new int[256];
        for (char ch : chs) {
            map[ch]++;
        }
        boolean hasOdd = false;
        for (int mi : map) {
            if (mi > 0 && ((mi & 1) == 1)) {
                if (hasOdd) {
                    return allRes;
                }
                hasOdd = true;
            }
        }

        String curPer = "";

        while (!curPer.equals(s)) {
            nextPermutation(chs);
            curPer = new String(chs);
            if (isPalindrome(curPer)) {
                allRes.add(curPer);
            }
        }
        return allRes;
    }

    public void nextPermutation(char[] chs) {
        int pivot = -1;
        for (int i = chs.length - 1; i > 0; i--) {
            if (chs[i - 1] < chs[i]) {
                pivot = i - 1;
                for (int j = chs.length - 1; j > pivot; j--) {
                    if (chs[j] > chs[pivot]) {
                        swap(j, pivot, chs);
                        break;
                    }
                }
                break;
            }

        }
        reverse(pivot + 1, chs.length - 1, chs);
    }

    private void swap(int i, int j, char[] chs) {
        char tp = chs[i];
        chs[i] = chs[j];
        chs[j] = tp;
    }

    private void reverse(int start, int end, char[] chs) {
        while (start < end) {
            swap(start, end, chs);
            start++;
            end--;
        }
    }

    private boolean isPalindrome(String str) {
        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

}
