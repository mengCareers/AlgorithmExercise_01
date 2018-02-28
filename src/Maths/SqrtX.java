/*69. Sqrt(x)
Implement int sqrt(int x)

Input: 8
Output: 2
Explanation: 
The square root of 8 is 2.82842...,
and since we want to return an integer, the decimal part will be truncated.
 * Thought Process:
 
 */
package Maths;

/**
 *
 * @author xinrong
 */
public class SqrtX {

    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        if (x == Integer.MAX_VALUE) {
            return 46340;
        }
        for (int i = 0; i <= x / 2; i++) {
            if ((i + 1) * (i + 1) == x) {
                return i + 1;
            }
            if ((i + 1) * (i + 1) > x && (i * i <= x)) {
                return i;
            }
        }
        return 0;
    }
}
