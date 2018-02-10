/*
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class FindMedianTwoSortedArrEqualSz {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        int[] nums2 = {2, 4, 6, 7};
        double ans = new FindMedianTwoSortedArrEqualSz().findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int l1 = nums1.length, l2 = nums2.length;
        int halfl = (l1 + l2 + 1) / 2;
        int imin = 0, imax = l1;
        while (imin <= imax) {
            int i = (imin + imax) / 2, j = halfl - i;
            if (i < imax && nums2[j - 1] > nums1[i]) {
                imin++;
            }
            else if (i > imin && nums1[i - 1] > nums2[j]) {
                imax--;
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0)
                    maxLeft = nums2[j - 1];
                else if (j == 0)
                    maxLeft = nums1[i - 1];
                else
                    maxLeft = Math.max(nums2[j - 1], nums1[i - 1]);
                
                if ((l1 + l2) % 2 == 1)
                    return maxLeft;
                
                int minRight = 0;
                if (i == nums1.length)
                    minRight = nums2[j];
                else if (j == nums2.length)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i], nums2[j]);
                
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
