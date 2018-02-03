package Maths;

/* 326. Power of Three
Q: input : n
   output: true if n is power of 3
 * Thought Process:
if it is power of 3, e.g. 27 = 3 * 3 * 3,
    27 / 3 / 3 / 3 = 1.
28 /
 * 
 */

/**
 *
 * @author xinrong
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;
    }    
}
