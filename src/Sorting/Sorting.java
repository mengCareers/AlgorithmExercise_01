/*
 * Thought Process:
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class Sorting {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public void selectionSort(int[] a) {
        int minidx = 0;
        for (int i = 0; i < a.length; i++) {
            minidx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minidx]) {
                    minidx = j;
                }
            }
            if (i != minidx) {
                swap(a, i, minidx);
            }
        }

    }

    public void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, hi);
    }

    private void merge(int[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int[] tmp = new int[hi - lo + 1];
        int p1 = lo;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= hi) {
            if (a[p1] < a[p2]) {
                tmp[p] = a[p1];
                p1++;
            } else {
                tmp[p] = a[p2];
                p2++;
            }
            p++;
        }
        while (p1 <= mid) {
            tmp[p] = a[p1];
            p1++;
            p++;
        }
        while (p2 <= hi) {
            tmp[p] = a[p2];
            p2++;
            p++;
        }
        // done
        int j = lo;
        for (int i = 0; i < tmp.length; i++) {
            a[j] = tmp[i];
            j++;
        }
    }

    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int w = partition(a, lo, hi);
            quickSort(a, lo, w - 1);
            quickSort(a, w + 1, hi);
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int lt = lo, i = lo, gt = hi;
        while (i <= gt) {
            if (a[i] < v) {
                swap(a, lt, i);
                lt++;
                i++;
            } else if (a[i] > v) {
                swap(a, gt, i);
                gt--;
            } else {
                i++;
            }
        }
        return i - 1;
    }

    private int threeWayPartition(int[] a, int lo, int hi) {
        int v = a[lo];
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) { // to shrink [i, gt]
            if (a[i] < v) {
                swap(a, lt++, i++);
            } else if (a[i] > v) {
                swap(a, gt--, i);
            } else {
                i++;
            }
        }
        return i - 1;
    }

    public void pancakeSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int midx = findMinIdx(a, i, a.length - 1);
            flip(a, i, midx);

            for (int t : a) {
                System.out.print(t + ", ");
            }
            System.out.println();
        }
    }

    private void flip(int[] a, int lo, int hi) {
        while (lo < hi) {
            swap(a, lo, hi);
            lo++;
            hi--;
        }
    }

    private int findMinIdx(int[] a, int lo, int hi) {
        int min = lo;
        for (int i = lo; i <= hi; i++) {
            if (a[i] < a[min]) {
                min = i;
            }
        }
        return min;
    }

    /* range from 0 to max
    1, 2, 2, 1, 3, 1, 5, 0
cnt 0  1  2  3  4  5
    1  3  2  1  0  1
     */
    public int[] countSort(int[] a, int max) {
        int[] cnt = new int[max + 1];
        for (int i : a) {
            cnt[i]++;
        }
        int sum = 0;
        int ci = 0;
        for (int i : cnt) {
            sum += i;
            cnt[ci++] = sum;
        }
        int[] res = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            int v = a[i];
            res[cnt[v] - 1] = v;
            cnt[v]--;
        }
        return res;
    }

    public static void main(String[] args) {
        Sorting inst = new Sorting();
        int[] a = {1, 2, 2, 1, 3, 1, 5, 0};

        a = inst.countSort(a, 5);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
