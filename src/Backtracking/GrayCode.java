/* 89. Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0. 
* Thought Process:
 * q. what is gray code?
   a. all posible combinations of 3 binary digits NONONO, if 011, 100 successive they differ more than one bits
000 0
001 1
010 2
011 3
100 4
101 5
110 6
111 7
   q. how to represent intermediate result, string or int
   a. int, * 2 !XXX use mask
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        grayCode(n, 0, result, 1 << n);
        System.out.println(result);
        return result;
    }

    private void grayCode(int n, int curres, List<Integer> result, int sz) {
        if (result.size() == sz) {

        } else {
            for (int i = 0; i < n; i++) {
                int mask = 1 << i;
                int el = (curres ^ mask);
                if (!result.contains(el)) {
                    result.add(el);
                    
                    grayCode(n, el, result, sz);                    
                }
            }
        }
    }

    private void allBinaryPermutation(int n, int curheight, int curres, List<Integer> result) {
        if (curheight == n) {
            result.add(curres);
        } else {
            curres = (curres ^ (1 << curheight));
            allBinaryPermutation(n, curheight + 1, curres, result);
            curres = (curres ^ (1 << curheight));
            allBinaryPermutation(n, curheight + 1, curres, result);
        }
    }

    public static void main(String[] args) {
        new GrayCode().grayCode(3);

    }
}
