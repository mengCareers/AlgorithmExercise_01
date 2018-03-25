/* 46. Permutations
Given a collection of distinct numbers, return all possible permutations.
public void permute(int[] nums)

Given a collection of distinct chars, return all possible permutations.
public void permute(char[] nums)

They show two methods of decreasing child nodes, that is, to see if i has been selected
    + Use boolean[] check, check[i] = true if i has been selected
    + Use method isValid(), iterate order to see if order[0, curptr) occur i
Here, i represent element on the ith element in nums
    e.g. char[] chnums = {'.', '!', '*'};
                        i  0    1    2
 * 
 */
package Backtracking;

/**
 *
 * @author xinrong
 */
public class Permutations {

    /**
     * Parameter is int[]
     *
     * @param nums
     */
    public void permute(int[] nums) {
        int len = nums.length;
        int[] order = new int[len];
        int curheight = 0;
        permuteUtil(order, curheight, nums);
    }

    /**
     * Parameter is char[]
     *
     * @param nums
     */
    public void permute(char[] nums) {
        int len = nums.length;
        int[] order = new int[len];
        int curheight = 0;
        permuteUtil(order, curheight, nums);
    }

    /**
     * Use check[] to decrease child nodes
     *
     * @param order
     * @param curheight
     * @param nums
     */
    private void permuteUtil(int[] order, int curheight, int[] nums) {
        if (curheight == nums.length) {
            printOrderArr(order, nums);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isValid(order, curheight, i)) {
                order[curheight] = i;
                permuteUtil(order, curheight + 1, nums);
            }
        }
    }

    /**
     * Use isValid() to decrease child nodes
     *
     * @param order
     * @param curheight
     * @param nums
     */
    private void permuteUtil(int[] order, int curheight, char[] nums) {
        if (curheight == nums.length) {
            printOrderArr(order, nums);
            return;
        }
        boolean[] check = new boolean[nums.length];
        for (int i = 0; i < curheight; i++) {
            check[order[i]] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (check[i] == false) {
                order[curheight] = i;
                permuteUtil(order, curheight + 1, nums);
            }
        }
    }

    /**
     * Valid if res[0, curptr) not occur i
     *
     * @param res
     * @param curptr
     * @param i
     * @return
     */
    private boolean isValid(int[] res, int curptr, int i) {
        for (int k = 0; k < curptr; k++) {
            if (res[k] == i) {
                return false;
            }
        }
        return true;
    }

    private void printOrderArr(int[] order, int[] nums) {
        for (int i : order) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    private void printOrderArr(int[] order, char[] nums) {
        for (int i : order) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] chnums = {'.', '*', '!'};
        new Permutations().permute(chnums);
        int[] intnums = {7, 8, 9};
        new Permutations().permute(intnums);
    }

}
