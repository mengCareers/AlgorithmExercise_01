/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class DPLec01 {

    public static void main(String[] args) {
        int[][] cost = {{1, 3, 7, 5}, {6, 8, 13, 2}, {9, 4, 4, 2}, {1, 3, 6, 8}};
        int minCost = minCostPath(cost);
        int numOfPaths = cntAllPaths(cost);
        int[] arr = {4, 2, 6, 8, 3, 1, 7, 0, 9, 5};
        int maxSum = maxSumIncreasingSequence(arr);
        int[] nums = {1, 2, 4, 5, 6};
        int target = 100;
        boolean canSubsetSum = subsetSumUsedOnce(nums, target);
        boolean isInterleaved = isInterleaved("fghi", "abcde", "abfcghdei");
        int cntBT = cntAllBTswiththePreorderTraversal(5);

        System.out.println(cntBT);
    }

    public static boolean isInterleaved(String A, String B, String C) {
        boolean[][] tmp = new boolean[A.length() + 1][B.length() + 1];
        tmp[0][0] = true;
        for (int i = 1; i < tmp.length; i++) {
            if (A.charAt(i - 1) == C.charAt(i - 1)) {
                tmp[i][0] = tmp[i - 1][0];
            }
        }
        for (int j = 1; j < tmp[0].length; j++) {
            if (B.charAt(j - 1) == C.charAt(j - 1)) {
                tmp[0][j] = tmp[0][j - 1];
            }
        }

        for (int i = 1; i < tmp.length; i++) {
            for (int j = 1; j < tmp[0].length; j++) {
                // init state
                // System.out.println("A : " + A.charAt(i - 1) + " B : " + B.charAt(j - 1) + " C : " + C.charAt(i + j - 1));
                if ((A.charAt(i - 1) == C.charAt(i + j - 1)) && (B.charAt(j - 1) != C.charAt(i + j - 1))) {
                    tmp[i][j] = tmp[i - 1][j];
                } else if ((A.charAt(i - 1) != C.charAt(i + j - 1)) && (B.charAt(j - 1) == C.charAt(i + j - 1))) {
                    tmp[i][j] = tmp[i][j - 1];
                } else if ((A.charAt(i - 1) == C.charAt(i + j - 1)) && (B.charAt(j - 1) == C.charAt(i + j - 1))) {
                    tmp[i][j] = tmp[i][j - 1] || tmp[i - 1][j];
                }

            }
        }
//        for (boolean[] tr : tmp) {
//            for (boolean ti : tr) {
//                if (ti) {
//                    System.out.print("T ");
//                } else {
//                    System.out.print("F ");
//                }
//            }
//            System.out.println();
//        }
        return tmp[tmp.length - 1][tmp[0].length - 1];
    }

    public static boolean isInterleavedRecursion(String s1, String s2, String s3, int p1, int p2, int p3) {
        if (p1 == s1.length() && p2 == s2.length() && p3 == s3.length()) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.charAt(p1) == s3.charAt(p3)) {
            return isInterleavedRecursion(s1, s2, s3, p1 + 1, p2, p3 + 1);
        }
        if (s2.charAt(p2) == s3.charAt(p3)) {
            return isInterleavedRecursion(s1, s2, s3, p1, p2 + 1, p3 + 1);
        }
        return false;
    }

    public static boolean subsetSumUsedOnce(int[] arr, int target) {
        boolean[][] tmp = new boolean[arr.length + 1][target + 1];
        tmp[0][0] = true;
        for (int i = 1; i < tmp.length; i++) {
            tmp[i][0] = true;
        }
        for (int j = 1; j < tmp[0].length; j++) {
            tmp[0][j] = false;
        }
        for (int i = 1; i < tmp.length; i++) {
            for (int j = 1; j < tmp[0].length; j++) {
                if (j < arr[i - 1]) {
                    tmp[i][j] = tmp[i - 1][j];
                } else {
                    if (tmp[i - 1][j - arr[i - 1]] || tmp[i - 1][j]) {
                        tmp[i][j] = true;
                    }
                }
            }
        }
        return tmp[tmp.length - 1][tmp[0].length - 1];
    }

    // BT(4) = BT(0) * BT(3) + BT(1) * BT(2) + BT(2) * BT(1) + BT(3) * BT(0)
    public static int cntAllBTswiththePreorderTraversal(int len) {
        if (len == 0) {
            return 0;
        }
        int[] tmp = new int[len + 1];
        tmp[0] = 1;
        tmp[1] = 1;
        System.out.println("tmp[0] = " + tmp[0]);
        System.out.println("tmp[1] = " + tmp[1]);
        for (int i = 2; i < tmp.length; i++) {
            System.out.print("tmp[" + i + "] = ");
            int sum = 0;
            for (int j = 0; j < i; j++) {

                sum += tmp[j] * tmp[i - 1 - j];
                int t = i - 1 - j;
                System.out.print("tmp[" + j + "] x tmp[" + t + "] + ");
            }
            System.out.println(" ;");
            tmp[i] = sum;
        }
        return tmp[len];
    }

    public static int maxSumIncreasingSequence(int[] arr) {
        int[] res = new int[arr.length];
        int[] prevIdx = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
            prevIdx[i] = i; // to print the result sequence HW
        }
        int maxRes = Integer.MIN_VALUE;
        int maxEndingIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (res[j] + arr[i] > res[i]) {
                        res[i] = res[j] + arr[i];
                        prevIdx[i] = j;
                        if (maxRes < res[i]) {
                            maxRes = res[i];
                            maxEndingIdx = i;
                        }
                    }
                }

            }
        }
        return maxRes;
    }

    public static int cntAllPaths(int[][] arr) {
        int[][] tmp = new int[arr.length][arr[0].length];

        // initial state
        tmp[0][0] = 1;
        for (int i = 1; i < tmp.length; i++) {
            tmp[i][0] = 1;
        }
        for (int j = 1; j < tmp[0].length; j++) {
            tmp[0][j] = 1;
        }

        for (int i = 1; i < tmp.length; i++) {
            for (int j = 1; j < tmp[0].length; j++) {
                tmp[i][j] = tmp[i - 1][j] + tmp[i][j - 1];
            }
        }

        return tmp[tmp.length - 1][tmp[0].length - 1];
    }

    public static int minCostPath(int[][] arr) {
        int[][] tmp = new int[arr.length][arr[0].length];

        // initial state
        tmp[0][0] = arr[0][0];
        for (int i = 1; i < tmp.length; i++) {
            tmp[i][0] = tmp[i - 1][0] + arr[i][0];
        }
        for (int j = 1; j < tmp[0].length; j++) {
            tmp[0][j] = tmp[0][j - 1] + arr[0][j];
        }

        for (int i = 1; i < tmp.length; i++) {
            for (int j = 1; j < tmp[0].length; j++) {
                tmp[i][j] = Math.min(tmp[i - 1][j - 1], Math.min(tmp[i - 1][j], tmp[i][j - 1])) + arr[i][j]; // right, down, diagnol action
            }
        }

        return tmp[tmp.length - 1][tmp[0].length - 1];
    }
}
