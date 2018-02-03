package Maths;

/* 342. Power of Four
Q: input : n
   output: true if n is power of 4

 * Thought Process:
 * 
 */

/**
 *
 * @author xinrong
 */
public class PowerofFour {
    public boolean isPowerOfFour(int n) {
        if (n < 1)
            return false;
        while (n % 4 == 0)
            n /= 4;
        return n == 1;
    }
}
