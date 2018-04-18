/* 66. Plus One
di => index in digits, starting from right end
Whenever a digit can plus 1 without carry, we return the digits.
Else, we set digits[di] to 0 and move left.
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int di = digits.length - 1;
        while (di >= 0) {
            if (digits[di] < 9) {
                digits[di]++;
                return digits;
            }
            digits[di] = 0;
            di--;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static int[] plusOneSLOW(int[] digits) {
        StringBuilder sb = new StringBuilder();
        int di = digits.length - 1;
        int digitSum = 1, carry = 0;
        while (di >= 0) {
            digitSum += digits[di];
            carry = digitSum / 10;
            sb.append(digitSum % 10);
            digitSum = carry;
            di--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        char[] digitsCh = sb.reverse().toString().toCharArray();
        int[] res = new int[digitsCh.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = digitsCh[i] - '0';
        }
        return res;
    }
}
