/*
树状数组
 * Thought Process:
 * 
 */
package datastructure;

/**
 *
 * @author xinrong
 */
public class BinaryIndexedTree {

    private static int[] e;
    private static int[] nums;

    public BinaryIndexedTree(int[] nums) {
        e = new int[nums.length + 1];
        this.nums = nums;
        buildBIT();
    }

    public int rangeSumFromTo(int start, int end) {
        return rangeSumFromStart(end) - rangeSumFromStart(start - 1);
    }

    private void buildBIT() {
        for (int i = 0; i < nums.length; i++)
            updateBIT(i + 1, nums[i]);
    }

    private static int rightmostOneUtility(int num) {
        return num & (~(num - 1));
    }

    private int rangeSumFromStart(int i) {
        int sum = 0;
        while (i > 0) {
            sum += e[i];
            i = i - rightmostOneUtility(i);
        }
        return sum;
    }

    private void updateBIT(int i, int value) {
        while (i < e.length) {
            e[i] += value;
            i = i + rightmostOneUtility(i);
        }
    }
}