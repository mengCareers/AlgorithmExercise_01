/*
 * Thought Process:
 * 
 */
package Searching;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class FindAllDisappearedinArr {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = findDisappearedNumbers(nums);
        System.out.println(res);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] cnt = new int[nums.length + 1];
        for (int nu : nums) {
            cnt[nu]++;
        }
//        printArr(cnt);
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    private static void printArr(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
