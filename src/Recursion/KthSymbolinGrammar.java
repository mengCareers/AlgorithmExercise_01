/* 779. K-th Symbol in Grammar
on the first row, we write a 0.
in every subsequent row, we look at the previous row and replace each 0 with 01, 1 with 10
input : row N and index K
output: the K-th indexed symbol in row N
row 1: 0
row 2: 0   1
row 3: 0 1 1 0
row 4: 01101001
 * Thought Process:
We look for where kth value comes from.
We define kth comes from xth in previous row :

k      x
1,2    1
3,4    2
...
if k % 2 == 0, x = k / 2; else, x = (k + 1) / 2;

We look for the tranfrom pattern from xth value to kth value

if xth value == 1,
if k % 2 == 0, kth value == 0
if k % 2 != 0, kth value == 1
if xth value == 0,
if k% 2 == 0, kth value == 1
if k% 2 != 0, kth value == 0
That is,
If k % 2 != 0, kth value is equal to xth value.
Else, if xth value = 1, kth value will be 0, if xth value = 0, kth value will be 1.
 */
package Recursion;

/**
 *
 * @author xinrong
 */
public class KthSymbolinGrammar {

    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }

        if (K % 2 == 0) {
            if (kthGrammar(N - 1, K / 2) == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (kthGrammar(N - 1, (K + 1) / 2) == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
