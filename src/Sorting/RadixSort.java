/*
 * Thought Process:
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] A = {82,93, 171};
        new RadixSort().sort(A);
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // get the maximum number to know # of digits
    int getMax(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
            }
        }
        return max;
    }

    void countsort(int[] A, int k) {
        int len = A.length;
        int[] res = new int[len];
        int[] cnt = new int[10];
        for (int i = 0; i < len; i++) {
            cnt[(A[i] / k) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            res[cnt[(A[i] / k) % 10] - 1] = A[i];
            cnt[(A[i] / k) % 10]--;
        }
        for (int i = 0; i < len; i++) {
            A[i] = res[i];
        }
    }

    public void sort(int[] A) {
        int max = getMax(A);
        for (int i = 1; max / i > 0; i *= 10) {
            countsort(A, i);
        }
    }
    
}
