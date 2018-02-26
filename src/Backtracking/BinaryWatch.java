/* 401. Binary Watch
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.
Example:
Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

 * Thought Process:
 * 
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class BinaryWatch {
    public static void main(String[] args) {
        List<String> res = new BinaryWatch().readBinaryWatch(1);
        System.out.println(res);
    }

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            //System.out.println(list1);
            List<Integer> list2 = generateDigit(nums2, num - i);
            //System.out.println(list2);
            // construct time
            for (int num1 : list1) {
                if (num1 >= 12) 
                    continue;
                for (int num2 : list2) {
                    if (num2 >= 60)
                        continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }
    
    List<Integer> generateDigit(int[] nums, int cnt) {
        List<Integer> res = new ArrayList<>();
        generateDigitUtil(nums, cnt, 0, 0, res);
        return res;
    }
    
    void generateDigitUtil(int[] nums, int cnt, int pos, int sum, List<Integer> res) {
        if (cnt == 0) {
            res.add(sum);
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            generateDigitUtil(nums, cnt - 1, i + 1, sum + nums[i], res);
        }
    }
}
