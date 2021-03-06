/* Q: when given a range
e.g. 1, 2, 2, 1, 3, 1, 5, 0 Range[0, 5]
 * Thought Process:
    0, 1, 2, 3, 4, 5
#   1  3  2  1  0  1
res is 1112235
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class CountSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 3, 1, 5, 0};
        new CountSort().countSort(arr, 0, 5); // min : 0, max : 5
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    void countSort(int[] arr, int min, int max) {
        int[] res = new int[arr.length];
        int[] cnt = new int[max - min + 1]; 
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
        }
//        for (int i : cnt) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }
//        for (int i : cnt) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        for (int i = arr.length - 1; i >= 0; i--) {
            res[cnt[arr[i]] - 1] = arr[i];
            cnt[arr[i]]--;
        }
//        for (int i : res) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
    }
}
