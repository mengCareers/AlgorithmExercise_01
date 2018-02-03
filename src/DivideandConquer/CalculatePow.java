/* compute x^n, e.g. 2^3 = 8
 * Thought Process:
    Naive: x * x *... x (n times)
    D&C  : Divide on x or n, we choose n
       x ^ n = x ^ (n/2) * x ^ (n/2) if n even
       x ^ n = x ^ ((n-1)/2) * x ^ ((n-1)/2) * x if n  odd
 */
package DivideandConquer;

/**
 * divide problem into sub of size y / 2
 * call sub recursively
 * @author xinrong
 */
public class CalculatePow {
    public int calPow(int x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return calPow(x, n / 2) * calPow(x, n / 2);
        else
            return x * calPow(x, n / 2) * calPow(x, n / 2);
    }
    public static void main(String[] args) {
        int ans = new CalculatePow().calPow(2, 4);
        System.out.println(ans);
    }
}
