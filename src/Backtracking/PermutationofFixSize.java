/*
 * Thought Process:
 * 
 */
package Backtracking;

/**
 *
 * @author xinrong
 */
public class PermutationofFixSize {

    /**
     * Test code for 'Create all Permutations of ABC of size 2 '
     *
     * @param args
     */
    public static void main(String[] args) {

        PermutationofFixSize inst = new PermutationofFixSize();
        inst.permutation("ABC", 2);

    }

    /**
     * Method to generate permutations of str in size sz.
     *
     * @param str
     * @param sz Length of each permutation.
     */
    public void permutation(String str, int sz) {
        if (str == null || str.length() == 0 || sz > str.length()) {
            return;
        }
        int[] res = new int[sz];
        int curptr = 0;
        permutationUtil(str, res, curptr);
    }

    /**
     * Util backtracking method to help generate permutations.
     *
     * @param str
     * @param res
     * @param curptr
     */
    private void permutationUtil(String str, int[] res, int curptr) {
        if (curptr == res.length) {
            printResult(res, str);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isValid(res, curptr, i)) {
                res[curptr] = i;
                permutationUtil(str, res, curptr + 1);
            }
        }
    }

    /**
     *
     * @param res
     * @param curptr
     * @param i
     * @return true if from [0, curptr), i not occur
     */
    private boolean isValid(int[] res, int curptr, int i) {
        for (int j = 0; j < curptr; j++) {
            if (res[j] == i) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to print result permutations.
     *
     * @param res
     * @param str
     */
    private void printResult(int[] res, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(str.charAt(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

}
