/*
 * Thought Process:
 * 
 */
package Searching;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class Searching {

    public boolean binarySearch(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < x) {
                lo = mid + 1;
            } else if (arr[mid] > x) {
                hi = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearchRecur(int[] arr, int x) {
        return binarySearchRecur(arr, x, 0, arr.length - 1);
    }

    private boolean binarySearchRecur(int[] arr, int x, int lo, int hi) {
        if (lo > hi) {
            return false;
        }
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] < x) {
            return binarySearchRecur(arr, x, mid + 1, hi);
        } else if (arr[mid] > x) {
            return binarySearchRecur(arr, x, lo, mid - 1);
        } else {
            return true;
        }
    }

    public void rotate(int[] arr, int num) {
        num = num % arr.length;
        // 1 2 3 4 5 6
        reverse(arr, 0, arr.length);
        // 6 5 4 3 2 1 num = 3
        reverse(arr, 0, num - 1);
        // 4 5 6 3 2 1
        reverse(arr, num, arr.length - 1);
        // 4 5 6 1 2 3
    }

    public void reverse(int[] arr, int s, int e) {
        int tmp;
        while (s < e) {
            tmp = arr[s];
            arr[s] = arr[e];
            arr[e] = tmp;
            s++;
            e--;
        }
    }

    public int getOccurances(int[] arr, int x) {
        return getOccurrences(arr, x, 0, arr.length - 1);
    }

    private int getOccurrences(int[] arr, int x, int lo, int hi) {
        if (hi < lo) {
            return 0;
        }
        if (arr[lo] > x) {
            return 0;
        }
        if (arr[hi] < x) {
            return 0;
        }
        if (arr[lo] == x && arr[hi] == x) {
            return hi - lo + 1;
        }
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == x) {
            return 1 + getOccurrences(arr, x, lo, mid - 1)
                    + getOccurrences(arr, x, mid + 1, hi);
        } else if (arr[mid] < x) {
            return getOccurrences(arr, x, mid + 1, hi);
        } else {
            return getOccurrences(arr, x, lo, mid - 1);
        }
    }

    public int getIdxFirstOccurrence(int[] arr, int x) {
        return getIdxFirstOccurrence(arr, x, 0, arr.length);
    }

    private int getIdxFirstOccurrence(int[] arr, int x, int lo, int hi) {
        if (hi < lo) {
            return -1;
        }
        if (arr[lo] > x) {
            return -1;
        }
        if (arr[hi] < x) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == x) {
            return getIdxFirstOccurrence(arr, x, lo, mid);
        } else if (arr[mid] < x) {
            return getIdxFirstOccurrence(arr, x, mid + 1, hi);
        } else {
            return getIdxFirstOccurrence(arr, x, lo, mid - 1);
        }
    }

    public void sortArrayWiggle(int[] arr) {
        Arrays.sort(arr);
        int tmp = 0;
        for (int i = 0; i < arr.length; i += 2) {
            tmp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tmp;
        }
    }

    int ceiling;

    public int ceilingSortedArray(int[] arr, int x) {
        if (arr[0] > x) {
            return 0;
        }
        if (arr[arr.length - 1] < x) {
            return -1;
        }
        ceiling = arr.length - 1;
        ceilingSortedArray(arr, x, 0, arr.length - 1);
        return ceiling;
    }

    private void ceilingSortedArray(int[] arr, int x, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == x) {
            ceiling = mid;
            return;
        } else if (arr[mid] < x) {
            ceilingSortedArray(arr, x, mid + 1, hi);
        } else {
            ceiling = mid;
            ceilingSortedArray(arr, x, lo, mid);
        }
    }

    public void moveZeroToEnd(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            if (arr[s] == 0) {
                swap(arr, s, e);
                e--;
            } else {
                s++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * all smaller than x, x, all bigger than x
     * @param arr
     * @param x 
     */
    public void dutchFlog(int[] arr, int x) { // x = a[lo] in 3-way partition
        int s = 0;
        int m = 0; 
        int e = arr.length - 1;
        /* 1 1 2 1 1 3 3 4   x = 3
                     s
                         m     
                       e 
        */    
        while (m <= e) {
            if (arr[m] == x) {
                m++;
            } 
            else if (arr[m] < x) {
                swap(arr, s, m);
                s++;
                m++;
            } 
            else {
                swap(arr, m, e);
                e--;
            }
        }
    }
    
    /**
     *     1 3 1 1 2 1 5
     * can 1 3 1 1 1 1 1
     * cnt 1 1 1 2 1 2 1
     * @param arr
     * @return 
     */
    public int findMajority(int[] arr) {
        int can = arr[0];
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != can) {
                cnt--;
            }
            else {
                cnt++;
            }
            if (cnt == 0) {
                can = arr[i];
                cnt = 1;
            }
        }
        return can;
    }

    public static void main(String[] args) {
        Searching inst = new Searching();
        int[] arr = {5, 4, 2, 1, 3, 3};
        int x = 3;
//        int ans = inst.ceilingSortedArray(arr, x);

        inst.dutchFlog(arr, x);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
       
    }
}
