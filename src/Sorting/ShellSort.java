/* 
 * Thought Process:
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 26, 13, 27, 49, 55, 49};
        new ShellSort().sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void sort(int[] arr) {
        int len = arr.length;
        int d = len / 2;
        while (d != 0) {
            // 对每组进行直接插入排序
            for (int i = d; i < len; i++) {
                int cur = arr[i];
                int j = i - d;
                while (j >= 0 && arr[j] > cur) {
                    arr[j + d] = arr[j];
                    j -= d;
                }
                arr[j + d] = cur;
            }
            d = d / 2;
        }
    }
}
