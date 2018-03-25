/* Q: 8. String to Integer (atoi)
 * Get:
        // +-n is illegal so will return 0
        // sum set to double to compare with Integer.MAX_VALUE and Integer.MIN_VALUE
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class StringtoIntegerAtoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        boolean positive = false;
        int i = 0;
        char init = str.charAt(i);        
        if (init == '+'){
            positive = true;
            i++;
        } 
        else if (init == '-') {
            i++;
        }
        else {
            positive = true;
        }
        int digit = 0;
        double sum = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            digit = str.charAt(i) - '0';
            sum = sum * 10 + digit;
            i++;
        }       
        if (!positive)
            sum = -sum;
        if (sum < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (sum > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)sum;
    }
}
