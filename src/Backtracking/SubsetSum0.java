package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * input: set, int k
 * output: List<List<Integer>>
 * TP: generage all subsums, if == k, add to res
 *     -> try one by one -> backtracking [Systematic Consideration]
 *     using tree diagrams to design Backtracking
 *     in diagram, node represents func call
 *                 branch represents candidate elements
 *     if the added sum satisfy constraint, we generate child nodes further
 *     whenever not, we stop further generation & backtrack to previous node to explore its child nodes not yet explored
 *     breadth by loop | depth by recursion
 */

public class SubsetSum0 {
    public static void main(String[] args) {
        int weights[] = {10, 7, 5, 18, 12, 20, 15};
        List<List<Integer>> res = new SubsetSum0().getSubSum(weights, 35);
        System.out.println(res);
    }

    List<List<Integer>> getSubSum(int[] arr, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(res, cur, arr, k, 0);
        return res;
    }
    void backtrack(List<List<Integer>> res, List<Integer> cur, int[] arr,int k, int movei) {
        if (getSum(cur) == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (movei == arr.length)
            return;
        for (int i = movei; i < arr.length; i++) {
            cur.add(arr[i]);
            backtrack(res, cur, arr, k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    int getSum(List<Integer> cur) {
        int sum = 0;
        for (int i : cur) {
            sum += i;
        }
        return sum;
    }
}