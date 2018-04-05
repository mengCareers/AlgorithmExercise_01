/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class PrintLongestBittonic {

    public static void main(String[] args) {
        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
        printLongestBittonic(nums);
        /**The results printed out are :
         * 1 11 10 5 2 1 
         * 1 2 10 5 2 1 
         * 1 2 4 5 2 1 
         */
    }

    /**
     * Find the longest bittonic sequence and print out all the bittonic numbers
     *
     * @param nums
     */
    static void printLongestBittonic(int[] nums) {
        List<List<Integer>> lis = getItemsLIS(nums);

        reverse(nums); // To get the Longest Decreasing Sequence
        List<List<Integer>> rlds = getItemsLIS(nums);
        List<List<Integer>> lds = reverse(rlds);

        reverse(nums);

        int max = 0; // To get the length of longest bittonic sequence
        for (int i = 0; i < nums.length; i++) {
            if (lis.get(i).size() + lds.get(i).size() - 1 > max) {
                max = lis.get(i).size() + lds.get(i).size() - 1;
            }
        }

        Set<Integer> maxIndices = new HashSet<>(); // To get all indices with the longest bittonic sequence
        for (int i = 0; i < nums.length; i++) {
            if (lis.get(i).size() + lds.get(i).size() - 1 == max) {
                maxIndices.add(i);
            }
        }

        for (int id : maxIndices) {
            print(lis.get(id), lis.get(id).size() - 1);
            print(lds.get(id), lds.get(id).size());
            System.out.println();
        }
    }

    /**
     * Get all Longest Increasing Sequences in nums[]
     *
     * @param nums
     * @return A list of all Longest Increasing Sequences
     */
    static List<List<Integer>> getItemsLIS(int[] nums) {
        List<List<Integer>> lis = new ArrayList<>();
        List<Integer> fst = new ArrayList<>();
        fst.add(nums[0]);
        lis.add(fst);
        for (int i = 1; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if ((nums[j] < nums[i]) && (lis.get(j).size() > tmp.size())) {
                    tmp = new ArrayList<>(lis.get(j));
                }
            }
            tmp.add(nums[i]);
            lis.add(tmp);
        }
        return lis;
    }

    /**
     * Reverse an array of integers
     *
     * @param nums
     */
    static void reverse(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
    }

    /**
     * Reverse the list of list of integers
     *
     * @param list
     * @return
     */
    static List<List<Integer>> reverse(List<List<Integer>> list) {
        List<List<Integer>> nlist = new ArrayList<>();
        for (List<Integer> li : list) {
            List<Integer> nli = reverseLi(li);
            nlist.add(0, nli);
        }
        return nlist;
    }

    /**
     * Reverse the list of integers
     *
     * @param list
     * @return
     */
    static List<Integer> reverseLi(List<Integer> list) {
        List<Integer> nlist = new ArrayList<>();
        for (int li : list) {
            nlist.add(0, li);
        }
        return nlist;
    }

    /**
     * Print the given number of elements from the start of the list
     *
     * @param list
     * @param sz The given number
     */
    static void print(List<Integer> list, int sz) {
        for (int i = 0; i < sz; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
