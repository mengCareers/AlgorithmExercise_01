/*
 *  LC:18. 4Sum
 *  Hint:HashTable TwoPointers Array
 *  Thought Process:
a + b + c + d = target;
a + b = target - (c + d)
 *  Get: using subfunc for 2sum & transfer ksum to (k-1)sum
 */
package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};

        List<List<Integer>> res = new FourSum().fourSum(nums, 0);
        for (List<Integer> r : res) {
            System.out.println(r);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSumUtil(nums, target, 4, 0);
    }

    private List<List<Integer>> kSumUtil(int[] nums, int target, int k, int idx) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            int i = idx, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    List<Integer> tans = new ArrayList<>();
                    tans.add(nums[i]);
                    tans.add(nums[j]);
                    res.add(tans);
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j - 1] == nums[j]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            for (int i = idx; i < nums.length - k + 1; i++) {
                List<List<Integer>> tmp = kSumUtil(nums, target - nums[i], k - 1, i + 1);

                for (List<Integer> t : tmp) {
                    t.add(0, nums[i]);
                }
                res.addAll(tmp);

                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
