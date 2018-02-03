/* to determine whether set can be partitioned into 2 subs with same sum
 * Thought Process:
 * BF: partition in all possible ways
       chk if same sum, return true
Get:
    that is, findSum(arr, arr.length, target);
    if target odd, return false in advance
    if target even,target is sum/2
        by recursion
            subproblems are w/ or w/o last element
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class Partition {
    public boolean findPartition(int[] arr) {
        int sum = 0;
        int i, j;
        for (i = 0; i < arr.length; i++) 
            sum += arr[i];
        if ((sum & 1) == 1)
            return false;
        int target = sum / 2;
        return findSum(arr, arr.length, target);
    }
    public  boolean findSum(int[] arr, int n, int target) {
        if (target == 0)
            return true;
        if (n == 0 && target != 0)
            return false;
        return findSum(arr, n - 1, target) || findSum(arr, n - 1, target - arr[n - 1]);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7};
        boolean ans = new Partition().findPartition(arr);
        System.out.println(ans);
    }
}
