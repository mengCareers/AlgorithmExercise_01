/* 
input : arr, n
right rotate arr for n times

 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class RotateArr {
    public static void main(String[] args) {
        int[] arr = {-1};
        new RotateArr().rightRotateArr(arr, 2);
    }
    
    void rightRotateArr(int[] arr, int n) {
        int len = arr.length;
        n = n % len; // without it, arr = {-1}, n = 2, will fail here*
                     // means n < len, that is n - 1 < len, can avoid fail here*
        reverse(arr, 0, len - 1);
        reverse(arr, 0, n - 1);
        reverse(arr, n, len - 1);
    }
    void reverse(int[] arr, int i, int j) {
        int tmp;
        while (i <= j) {
            tmp = arr[i];
            arr[i] = arr[j]; // *
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
