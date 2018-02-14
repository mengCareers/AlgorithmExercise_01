/* 29. Divide Two Integers
input : dividend, divisor
output: dividend / divisor without multipy, division or mod
 * Thought Process: sign, overflow, divideProcess should be decoupled
 * Get : int -2147483648 .abs is -2147483648
         long-2147483648 .abs is 2147483648

         a += a EQUAL TO a *= 2
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        int res1 = Math.abs(Integer.MIN_VALUE);
        System.out.println(res1);
        long res2 = Math.abs(Integer.MIN_VALUE);
        System.out.println(res2);
        long res3 = Math.abs((long)Integer.MIN_VALUE);
        System.out.println(res3);
    }

    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long lans = ldivide(ldividend, ldivisor);
        int ans = 0;
        if (lans > Integer.MAX_VALUE) {
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }
//        int cnt = 0;
//        long sum = ldivisor;
//        while (sum <= ldividend) {
//            cnt++;
//            sum += ldivisor;
//        }
//        return cnt;
        long sum = ldivisor;
        long cnt = 1;
        while (sum + sum <= ldividend) {
            sum += sum;
            cnt += cnt;
        }
        return cnt + ldivide(ldividend - sum, ldivisor);
    }

}
