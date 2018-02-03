package Maths;

/* Q: 343.Integer Break
input : n
output: break n into sum of at least two posive integers
        return the max product you can get
 * Thought Process:
try one by one, backtrack, if could, dp
BF: get all possible combinations of break, and calculate each product, return the max
 * Get:
- What's the basic problem? 
max product if we break N into 2 factors
- How to solve it?
f = x * (N - x),
fmax = (N/2) * (N/2) OR ((N-1)/2) * ((N+1)/2)
- How to decide if it should continue to break?
if n = 2, 1 * 1 < 2
if n = 3, 1 * 2 < 3
if n = 4, 2 * 2 = 4
if n = 5, 3 * 2 = 6
if n = 6, 3 * 3 = 9
if n = 7, 3 * 4 = 12
if n = 8, 3 * 5 X 
          3 * 3 * 3
that is, only if N <= 4, otherwise we can do the break
the factors in the last result should be 1(abondoned), 2, 3, 
So the factors of the perfect product should be 2 or 3
- Why we choose 3?
e.g. For 6, 3 * 3 > 2 * 2 * 2
 */

/**
 *
 * @author xinrong
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int product = 1;
        while (n > 4) {
            product = product * 3;
            n -= 3;
        }
        return product;
    }    
}
