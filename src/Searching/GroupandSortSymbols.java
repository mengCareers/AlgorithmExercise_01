/*
// Q1 : a[] consists of -1s. 0s, 1s, group in order
Q2 : pick a symbol as pivot in Quicksort
x is the pivot to partition
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class GroupandSortSymbols {
    public static void main(String[] args) {
        int[] a = {2, 3, -7, 4, 0, 0, -2};
        new GroupandSortSymbols().groupAndSort(a, 0);
        for (int i : a) 
            System.out.print(i + " ");
    }
    void groupAndSort(int[] a, int x) {
        int s = 0, m = 0, e = a.length - 1;
        while (m <= e) {
            if (a[m] < x) {
                swap(a, s, m);
                
                for (int i : a) 
                    System.out.print(i + " ");
                System.out.println();
                
                s++;
                m++;
            }
            else if (a[m] > x) {
                swap(a, m, e);
                
                for (int i : a) 
                    System.out.print(i + " ");
                System.out.println();
               
                e--;
            } 
            else {
                m++;
            }
        }
    }
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
