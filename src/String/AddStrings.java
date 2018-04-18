/*
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }
        int l1 = num1.length(), l2 = num2.length();
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int offset = l1 - l2;
        int digitSum = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = l2 - 1; i >= 0; i--) {
            int j = offset + i;
            digitSum += (ch1[j] - '0') + (ch2[i] - '0');
            carry = digitSum / 10;
            sb.append(digitSum % 10);
            digitSum = carry;
        }
        for (int j = offset - 1; j >= 0; j--) {
            digitSum += ch1[j] - '0';
            carry = digitSum / 10;
            sb.append(digitSum % 10);
            digitSum = carry;
        }
        if (digitSum != 0) {
            sb.append(digitSum);
        }
        return sb.reverse().toString();
    }
}
