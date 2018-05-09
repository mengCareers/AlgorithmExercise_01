/* 409. Longest Palindrome
Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here. 
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

 * Thought Process:
backtracking, emulate all possible palindromes, get the longest 
wait.. we can break the order
xxyy only one is odd
A valid palindrome can only contain a char that the number of it is odd.
So if we meet such char again, we need to remove one of it from the palindrome candidate to ensure valid.
e.g.
xxoooxex
number of o is 3, which is odd
number of e is 1, which is also odd,
we need to remove a 'o' or 'e', to ensure valid
 * 
 */
package Hashing;

/**
 *
 * @author xinrong
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] hash = new int[256];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        boolean isOdd = false;
        int len = s.length();
        for (int h : hash) {
            if ((h & 1) == 1) {
                if (isOdd) {
                    len--;
                }
                isOdd = true;
            }
        }
        return len;
    }
}
