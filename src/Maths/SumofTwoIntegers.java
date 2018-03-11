/* 
371. Sum of Two Integers
 * Thought Process:
 * 
    进位 when both 1 => a & b << 1 
    + ^             => a ^ b
 * + => recursion 代替
 * e.g. 00000001 = 1
        00000011 = 3
       =00000010
       +00000010
       =00000000
       +00000100
       =00000100
       +00000000
       return 00000100 = 4
 */
package Maths;

/**
 *
 * @author xinrong
 */
public class SumofTwoIntegers {

    public int getSum(int a, int b) {
        if (b == 0)
            return a;
        return getSum((a ^ b), ((a & b) << 1));
    }
}
