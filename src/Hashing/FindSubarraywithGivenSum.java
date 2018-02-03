/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xinrong
 */
public class FindSubarraywithGivenSum {
    public boolean subArraySum(int nums[], int sum) {
        int len = nums.length;
        int currSum = nums[0];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            currSum= currSum + nums[i]; 
            if (set.contains(currSum - sum)) return true;
            else {
                set.add(currSum);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -30, 10};
        int sum = -20;
        boolean ans = new FindSubarraywithGivenSum().subArraySum(arr, sum);
        System.out.println(ans);
    }
}
