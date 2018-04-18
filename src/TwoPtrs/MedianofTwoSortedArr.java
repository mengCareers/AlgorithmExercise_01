/*
Searching i in [0, m], to find an object i such that
B[j - 1] <= A[i] && A[i - 1] < B[j] where j = (m + n + 1) / 2 - i;*
Binary Search :
if *, i found. if m + n odd, max(A[i - 1], B[j - 1])
if m + n even,min(A[i], B[j]) / 2
else if B[j - 1] > A[i], i is too small
else if A[i - 1] > B[j], i is too big
Attention : We use iMin and iMax to indicate i’s valid searching range. Then, we iMin++ or iMax-- to adjust i’s value in Binary Search.
 */
package TwoPtrs;

/**
 *
 * @author xinrong
 */
public class MedianofTwoSortedArr {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l1 = nums1.length, l2 = nums2.length;
        int iMin = 0, iMax = l1, halfLen = (l1 + l2 + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i > iMin && nums1[i - 1] > nums2[j]) {
                // i is too big
                iMax--;
            } else if (i < iMax && nums2[j - 1] > nums1[i]) {
                // i is too small
                iMin++;
            } else {
                // i is right
                int leftMax = 0;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((l1 + l2) % 2 == 1) {
                    return leftMax;
                }

                int rightMin = 0;
                if (i == l1) {
                    rightMin = nums2[j];
                } else if (j == l2) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
}
