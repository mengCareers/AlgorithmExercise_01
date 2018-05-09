/*
if n is even, replace n with n / 2
if n is odd,  replace n with n + 1 or n - 1
What is the minimum number of replacements needed for n to become 1
Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
 * Thought Process:
if even, just / 2 unitl 1, count /
if odd, try
 * 
 */
package Recursion;

/**
 *
 * @author xinrong
 */
public class IntegerReplacement {

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == Integer.MAX_VALUE) {
            return 32;
        }

        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }

        return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));

    }

}
