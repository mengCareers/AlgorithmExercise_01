/* like sort playing cards in hands
 * Get:
    sort(arr, n)
    loop
        pick arr[i] and insert into sorted [0.. i - 1]
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2, 3};
        new InsertionSort().sort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
    void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int k = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
        }
    }
}
