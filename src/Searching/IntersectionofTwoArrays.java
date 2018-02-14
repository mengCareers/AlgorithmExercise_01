/* 349. Intersection of Two Arrays
input : int[] nums1, int[] nums2
output: intersection[] without duplicates
 * Thought Process:
 * Get : for (Integer i : set)
 */
package Searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        int l1 = nums1.length, l2 = nums2.length;
        if (l1 == 0 || l2 == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();

        int i1 = 0, i2 = 0;
        while (i1 < l1 && i2 < l2) {
            int t1 = nums1[i1];
            int t2 = nums2[i2];
            if (t1 == t2) {
                set.add(t1);
                i1++;
                i2++;
            } else if (t1 < t2) {
                i1++;
            } else {
                i2++;
            }
        }

        int[] res = new int[set.size()];
        int i = 0;
        for (Integer s : set) {
            res[i++] = s;
        }

        return res;
    }
}
