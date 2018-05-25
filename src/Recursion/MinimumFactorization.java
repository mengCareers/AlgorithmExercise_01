/* 625.Minimum Factorization
input : a
output: smallest positive integer b whose multiplication of each digit equals to a
 * Thought Process:
e.g. 
48
6 x 8
8 x 6 .. They are all factors of 48
15
3 x 5
5 x 3 .. They are all factors of 15
our problem [reduces] to find the factors of a and finding their smallest possible arrangement
we start with trying with the [largest possible factor 9
obtain as many such counts of this factor as possible in res
and place such factors at its least significant positions
from 9 to 2
re
 * 
 */
package Recursion;

/**
 *
 * We only need to pick the largest factor in [2, 9] each time and put it to the front of current result. (So that the first pick is put at the least significant digit).
Why it works?
Lets forget about how we put the digits for a moment. If we just pick the largest factor in [2, 9] every time, we can guarantee the result has the shortest length (least digits).
Now if we have the shortest length, the way to make this number smallest is to put the largest one to the least significant.
Hence this algorithm.
 * @author xinrong
 */
public class MinimumFactorization {
    public static void main(String[] args) {
        MinimumFactorization inst = new MinimumFactorization();
        int a = 25;
        int ans = inst.smallestFactorization(a);
        System.out.println(ans);
    }

    public int smallestFactorization(int a) {
        if (a <= 1) {
            return a;
        }
        long smallestVal = 0, displacement = 1;
        for (int factor = 9; factor >= 2; factor--) {
            while (a % factor == 0) {
                a /= factor;
                smallestVal += displacement * factor;
                displacement *= 10;
            }
        }
        return (a == 1 && smallestVal <= Integer.MAX_VALUE) ? (int) smallestVal : 0;
    }
}
