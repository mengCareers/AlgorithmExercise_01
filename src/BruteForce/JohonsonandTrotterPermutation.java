/*
def : We are given a sequence of numbers from 1 to n. 
Each permutation in the sequence that we need to generate should differ from the previous permutation 
by swapping just two adjacent elements of the sequence.
 * Thought Process:
 * 
 */
package BruteForce;

/**
 *
 * @author xinrong
 */
public class JohonsonandTrotterPermutation {

    public static void main(String[] args) {
        Num[] arr = new Num[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Num(i + 1);
        }
        JohonsonandTrotterPermutation inst = new JohonsonandTrotterPermutation(arr);
        inst.printPermutations();
    }

    static class Num {

        int val;
        boolean isLeft;
        boolean isMobile;

        public Num(int val) {
            this.val = val;
            isLeft = true;
            isMobile = false;
        }
    }

    Num[] arr;

    public JohonsonandTrotterPermutation(Num[] arr) {
        this.arr = arr;
        updateMobile();
    }

    private void updateMobile() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isLeft && i - 1 >= 0 && arr[i].val > arr[i - 1].val) {
                arr[i].isMobile = true;
            } else if (!arr[i].isLeft && i + 1 < arr.length && arr[i].val > arr[i + 1].val) {
                arr[i].isMobile = true;
            } else {
                arr[i].isMobile = false;
            }
        }
    }

    private int getLargestMobile() {
        Num tmp = null;
        int ti = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isMobile) {
                if (tmp == null) {
                    tmp = arr[i];
                    ti = i;
                } else if (tmp.val < arr[i].val) {
                    tmp = arr[i];
                    ti = i;
                }
            }
        }
        return ti;
    }

    /**
     * Swap arr[i] with the next one in direction
     *
     * @param cur
     */
    public void swapNext(int i) {
        Num cur = arr[i];
        if (cur.isLeft) {
            swapUtil(i, i - 1);
        } else {
            swapUtil(i, i + 1);
        }
    }

    private void swapUtil(int i, int j) {
        if (j < 0 || j >= arr.length) {
            return;
        }
        Num tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void switchDirections(Num ni) {

        for (int ti = 0; ti < arr.length; ti++) {
            if (arr[ti] == ni) {
                continue;
            }
            Num n = arr[ti];
            if (n.val > ni.val) {
                n.isLeft = !n.isLeft;
            }
        }
    }

    public void printArr() {
        for (Num n : arr) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }

    public void printPermutations() {
        printArr();
        Num ni = null;
        while (getLargestMobile() != -1) {
            int ti = getLargestMobile();
            ni = arr[ti];
            swapNext(ti);
            printArr();
            switchDirections(ni);
            updateMobile();
        }

    }
}
