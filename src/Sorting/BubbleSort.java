/* 6, 5, 3, 1, 2, 7, 8, 4
   5  3  1  2  6  7  4  8
 * Thought Process:
 * the smallest is located first
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 2, 7, 8, 4};
        new BubbleSort().bubbleSort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }    
    void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
//                    for (int z : arr) {
//                        System.out.print(z + " ");                        
//                    }
//                    System.out.println();
                }
            }
        }
    }
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
