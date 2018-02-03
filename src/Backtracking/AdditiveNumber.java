package Backtracking;

/* 306.Additive Number
 * Thought Process:
backtracking
f s t
0 i j
s t t + res.len
 * 
 */

/**
 *
 * @author xinrong
 */
public class AdditiveNumber {
    public static void main(String[] args) {
        boolean ans = new AdditiveNumber().isAdditiveNumber("1023");
        System.out.println(ans);
    }
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n; i++) {
            if (i > 1 && num.charAt(0) == '0') // 000 is true
                break;
            for (int j = i + 1; j < n; j++) {
                int first = 0, second = i, third = j;
                if (num.charAt(second) == '0' && third > second + 1) // 101 is true
                    break;
                while (third < n) {
                    Long res = Long.parseLong(num.substring(first, second))
                            + Long.parseLong(num.substring(second, third));
                    if (num.substring(third).startsWith(res.toString())) {
                        first = second; 
                        second = third;
                        third += res.toString().length();
                    }
                    else 
                        break;
                }
                if (third == n)
                    return true;
            }
        }
        return false;
    }
}
