/*
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class StringtoIntegerAtoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int vi = 0;
        char flag = '+';
        if (str.charAt(vi) == '-') {
            flag = '-';
            vi++;
        } else if (str.charAt(vi) == '+') {
            vi++;
        }
        double res = 0;
        while (vi < str.length() && str.charAt(vi) >= '0' && str.charAt(vi) <= '9') {
            res = res * 10 + (str.charAt(vi) - '0');
            vi++;
        }
        if (flag == '-') {
            res = -res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
