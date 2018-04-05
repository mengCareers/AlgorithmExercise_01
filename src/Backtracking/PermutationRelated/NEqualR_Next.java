/*
 * Thought Process:
 * 
 */
package Backtracking.PermutationRelated;

/**
 *
 * @author xinrong
 */
public class NEqualR_Next {

    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot = i - 1;
                for (int j = nums.length - 1; j > pivot; j--) {
                    if (nums[j] > nums[pivot]) {
                        swap(j, pivot, nums);
                        break;
                    }
                }
                break;
            }
        }

        reverse(pivot + 1, nums.length - 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int tp = nums[i];
        nums[i] = nums[j];
        nums[j] = tp;
    }

    /**
     * reverse nums from start to end inclusively
     *
     * @param start
     * @param end
     * @param nums
     */
    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }
}
