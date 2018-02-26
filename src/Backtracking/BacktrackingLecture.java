/*
 * Thought Process:
 * 
 */
package Backtracking;

/**
 * @author xinrong
 */
public class BacktrackingLecture {

    public static void main(String[] args) {
        BacktrackingLecture inst = new BacktrackingLecture();
        /*
        // To generate Subsets
        inst.subset("ABC");
                 
        // To generate Permutations
        inst.permutation("ABC", 2);

        // To generate Combinations
        inst.comb("ABC", 2);
        
        // To generate Xary Sequence
        inst.generateBiSeq(2);
        inst.generateXarySeq(2, 4);
         */
    }

    public void subset(String str) {
        if (str.length() == 0) {
            return;
        }
        int[] res = new int[str.length()];
        int curptr = 0;
        subsetUtil(str, res, curptr);
    }

    private void subsetUtil(String str, int[] res, int curptr) {
        if (curptr == res.length) {
            printSubset(res, str);
            return;
        }
        for (int i = 0; i < 2; i++) {
            res[curptr] = i;
            subsetUtil(str, res, curptr + 1);
        }
    }

    private void printSubset(int[] res, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1) {
                sb.append(str.charAt(i));
            }
        }
        sb.append("}");
        System.out.print(sb.toString());
        System.out.println();
    }

    public void permutation(String str, int sz) { // all chars unique in str
        if (str.length() == 0) {
            return;
        }
        int[] res = new int[sz];
        int curptr = 0;
        permutationUtil(str, res, curptr);
    }

    private void permutationUtil(String str, int[] res, int curptr) {
        if (curptr == res.length) {
            printPermutation(res, str);
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

    private void printPermutation(int[] res, String str) {
        for (int i : res) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public void comb(String str, int n) {
        if (str.length() == 0 || n <= 0) {
            return;
        }
        int[] res = new int[n];
        int curptr = 0;
        combUtil(str, n, res, curptr);
    }

    private void combUtil(String str, int n, int[] res, int curptr) {
        if (curptr == res.length) {
            printComb(res, str);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            res[curptr] = i;
            combUtil(str, n, res, curptr + 1);
        }
    }

    void printComb(int[] res, String str) {
        for (int i : res) {
            char c = str.charAt(i);
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void generateBiSeq(int n) {
        if (n <= 0) {
            return;
        }
        int[] res = new int[n];
        int curptr = 0;
        generateBiSeqUtil(res, curptr);
    }

    private void generateBiSeqUtil(int[] res, int curptr) {
        if (res.length == curptr) {
            printArray(res);
            return;
        }
        for (int i = 0; i < 2; i++) {
            res[curptr] = i;
            generateBiSeqUtil(res, curptr + 1);
        }
    }

    public void generateXarySeq(int n, int x) {
        if (n <= 0) {
            return;
        }
        int[] res = new int[n];
        int curptr = 0;
        generateXarySeqUtil(res, curptr, x);
    }

    private void generateXarySeqUtil(int[] res, int curptr, int x) {
        if (res.length == curptr) {
            printArray(res);
            return;
        }
        for (int i = 0; i < x; i++) {
            res[curptr] = i;
            generateBiSeqUtil(res, curptr + 1);
        }
    }

    void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
