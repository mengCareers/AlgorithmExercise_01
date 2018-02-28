/* 43. Multiply Strings
Given two non-negative integers num1 and num2 represented as strings, 
return the product of num1 and num2.
 * Thought Process:
 * 
 */
package Maths;

/**
 *
 * @author xinrong
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = res[i + j + 1] + product;
                res[i + j + 1] = sum % 10; // =
                res[i + j] += sum / 10; // +=
            }
        }
        StringBuilder sb = new StringBuilder();
        int ri = 0;
        if (res[0] == 0) 
            ri = 1;
        for (; ri < res.length; ri++) {
            sb.append(res[ri]);
        }
        
        return sb.toString();
    }
}
