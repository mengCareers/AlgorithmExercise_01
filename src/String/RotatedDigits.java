/* 788. Rotated Digits
 * Thought Process:
 * 2 - 5
   6 - 9
   
 */
package String;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class RotatedDigits {
    
    public static void main(String[] args) {
        RotatedDigits rd = new RotatedDigits();
        rd.rotatedDigits(3);
        int r = rd.rotatedDigits(857);
        System.out.println(r);
    }

    Set<Integer> set;

    public int rotatedDigits(int N) {
        set = new HashSet<>();
        set.add(2);
        set.add(5);
        set.add(6);
        set.add(9);
        set.add(0);
        set.add(1);
        set.add(8);
        int cnt = 0;
        for (int num = 1; num <= N; num++) {
            if (isGood(num)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isGood(int num) {
        int n = num;
        while (num != 0) {
            int i = num % 10;
            if (!set.contains(i)) {
                return false;
            }
            num = num / 10;
        }
        
        if (!isDiff(n))
            return false;
        
        return true;
    }
    
    private boolean isDiff(int num) {
        String n = String.valueOf(num);
        if (!n.contains("2") && 
                !n.contains("5") &&
                !n.contains("6") &&
                !n.contains("9"))
            return false;
        return true;
    }
}
