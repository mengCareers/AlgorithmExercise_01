/* 50. Pow(x, n)
Implement pow(x, n).
Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
 * Thought Process:
 * 
 */
package Maths;

/**
 *
 * @author xinrong
 */
public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        return (n > 0 ? x * myPow(x * x, n / 2) : (1 / x) * myPow(x * x, n / 2));
    }
}
