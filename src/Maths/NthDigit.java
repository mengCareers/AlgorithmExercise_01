package Maths;

/* 400. Nth Digit
 * Thought Process:
 * within 0 - 9
 */

/**
 *
 * @author xinrong
 */
public class NthDigit {

    /*
    digitLvl    cnts                                    startN
    1           9           9 numbers with 1 digit      1
    2           90         90 numbers with 2 digit      10
    3           900       900 numbers with 3 digit      100
     */
    public int findNthDigit(int n) {
        int digitLvl = 1;
        long cnts = 9;
        while (n - digitLvl * cnts > 0) {
            n -= digitLvl * cnts;
            digitLvl++;
            cnts *= 10;
        }
        int startN = (int) Math.pow(10, digitLvl - 1);
        int finalN = startN + (n - 1) / digitLvl;
        int whichDigit = (n - 1) % digitLvl;
        return String.valueOf(finalN).charAt(whichDigit) - '0';
    }
}
