/*
 * Thought Process:
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {7, 5, 11, 6, 12, 13};
        new HeapSort().heapsort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public void heapsort(int[] nums) {
        // construct heap
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxheapify(nums, nums.length, i);
        }

        int cnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            // exchange (remove root)
            int t = nums[0];
            nums[0] = nums[i];
            nums[i] = t;

            // maxheapify
            maxheapify(nums, i, 0);
            
        }
    }

    // can only guarantee the first swap are valid
    private void maxheapify(int[] nums, int sz, int rootidx) {
        int lidx = rootidx * 2 + 1;
        int ridx = rootidx * 2 + 2;
        int largest = rootidx;
        if (lidx < sz && nums[largest] < nums[lidx]) {
            largest = lidx;
        }
        if (ridx < sz && nums[largest] < nums[ridx]) {
            largest = ridx;
        }
        if (largest != rootidx) {
            // swap
            int t = nums[rootidx];
            nums[rootidx] = nums[largest];
            nums[largest] = t;
            maxheapify(nums, sz, largest);
        }
    }
}
