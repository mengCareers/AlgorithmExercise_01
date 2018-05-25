/* 338.Counting Bits
input : num
    for every numbers i in the range 0 <= i <= num
    calculate # of 1's in their binary representation
    and return them as an array
output : # of 1's in binary representation of 0 <= i <= num as an array
 * Thought Process:
The problem is to count # of 1's in binary representation of 0 <= i <= num as an array
we define STATE as # of 1's in binary representation of i (for 0 <= i <= num)
END STATE is # of 1's in binary representation of num
STATE TRANSFER :
000     0   0
001     1   1
010     1   2
011     2   3

100     1   4
101     2   5   
110     2   6
111     3   7

P(x + b) = P(x) + 1
P(0 + 2) = P(0) + 1
P(1 + 2) = P(1) + 1

P(4 + 2) = P(4) + 1
P(5 + 2) = P(5) + 1

...

 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class CountingBits {

    public int[] countBits(int num) {

    }
}
