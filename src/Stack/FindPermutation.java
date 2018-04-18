/*
For a given n, we need to use all the integers in the range (1,n) to generate a lexicographically smallest permutation of these n numbers 
which satsfies the pattern given in the string s
 * Thought Process:
lexicographically smallest permutation 
    => as close as possible to min
    => the digits lying towards the most significant positions are as small as possible while satisfying the given pattern   
e.g.
    s = "DDIIIID"
    n=8
    the minmin permutation possible will be [1, 2, 3, 4, 5, 6, 7, 8]
    to satisfy the first two "DD" pattern, rearrange only 1, 2, 3, leading to the formation of [3, 2, 1, 4, 5, 6, 7, 8] 
    irrespective of how we rearrange 1, 2, 3, satisfying the first I
        => minmin number considered originally always satisfies the increasing criteria
    to satisfy the last 'D', rearrange only 7, 8, leading to the formation of [3, 2, 1, 4, 5, 6, 8, 7]
=> to generate the required arrangement, we can start off with the minmin number that can be formed for the given n. 
   to reverse only those subsections hich have a D in the pattern at their corresponding positions.
 * 
 */
package Stack;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class FindPermutation {

    public int[] findPermutation(String s) {
        int n = s.length() + 1;
        int[] res = new int[n];
        int ri = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == 'I') {
                stack.push(i);
                while (!stack.isEmpty()) {
                    res[ri++] = stack.pop();
                }
            } else {
                stack.push(i);
            }
        }
        stack.push(n); // it works no matter last char in s is 'I' or 'D'
        while (!stack.isEmpty()) {
            res[ri++] = stack.pop();
        }
        return res;
    }
}
