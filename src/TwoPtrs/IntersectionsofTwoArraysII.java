package TwoPtrs;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/* 350. Intersection of Two Arrays II
input: nums1, nums2
output: int[] represents intersection
 * Thought Process:
- What does it mean by intersection?
ele appear the same time
we use hashing, map<num, freq>
for a num, get minfreq, add to res
e.g. 1 2 2 1 vs 2 2
1 : 2
2 : 2
vs
2 : 2
 * Get:
sort int[]s, use 2 ptrs
if same, both ++, add to list
if <, p1++
if >, p2++
 */

/**
 *
 * @author xinrong
 */
public class IntersectionsofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        List<Integer> res = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2])
                p1++;
            else if (nums1[p1] > nums2[p2])
                p2++;
            else {
                res.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] ans = new int[res.size()];
        int j = 0;
        for (int i : res)
            ans[j++] = i;
        return ans;
    }
    /*
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i : nums1) 
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        for (int i : nums2)
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        for (int i : map1.keySet()) {
            if (map2.containsKey(i)) {
                // cnt 个 i
                int cnt = Math.min(map1.get(i), map2.get(i));
                while (cnt > 0) {
                    res.add(i);
                    cnt--;
                }
            }
        }
        int[] ans = new int[res.size()];
        int j = 0;
        for (int i : res)
            ans[j++] = i;
        return ans;
    }    
    */
}
