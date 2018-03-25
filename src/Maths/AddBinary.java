/*
 * Thought Process:
 *  charat(idx) from left to right
    add from right to left
    dist should be counted
    carry should be set 0 if already added to sum
 */
package Maths;

/**
 *
 * @author xinrong
 */
public class AddBinary {

    public static void main(String[] args) {
        String ans = new AddBinary().addBinary("110010", "100");
        System.out.println(ans);
    }

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        StringBuilder res = new StringBuilder();
        int sumab = 0;
        int carry = 0;
        int numa = 0;
        int numb = 0;
        int dist = a.length() - b.length();
        for (int i = b.length() - 1; i >= 0; i--) {
            numa = a.charAt(i + dist) - '0';
            numb = b.charAt(i) - '0';
            sumab = numa + numb + carry;
            carry = 0;
            if (sumab >= 2) {
                carry = sumab / 2;
                sumab = sumab % 2;
            }
            res.append(sumab);
        }
        int suma = 0;
        for (int j = dist - 1; j >= 0; j--) {
            numa = a.charAt(j) - '0';
            suma = numa + carry;
            carry = 0;
            if (suma >= 2) {
                carry = suma / 2;
                suma = suma % 2;
            }
            res.append(suma);
        }
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
