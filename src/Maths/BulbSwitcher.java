package Maths;


import static java.lang.Math.sqrt;

/* 319.Bulb Switcher
Q: On the 1st round, turn on all the bulbs
   On the 2nd round, turn on every second bulb
   for the ith round, toggle every i bulb
   for the nth round, toggle the last bulb
   return # of bulbs are on after n rounds
 * Get :
- What's the law?
    the bulb i is toggled k times, such that k is # of i's factors except 1
    e.g. Factors of 6 : 1, 2, 3, 6. bulb 6 will be toggled 3 times.
- How does it simplify the problem?
    key is to judge whether k is even of odd, if even, on in the end
- What's the law then?
    if p is i's factor, q = i / p is also i's factor
    if i has no factor p that makes p = i / p [i isnot  perfect square], k + 1 is even, k is odd
- How does it simplify the problem?
    to find out # of perfect square numbers are NO MORE than n
    that is, square root of the maximum perfect square number is NO MORE than n
 */

/**
 *
 * @author xinrong
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int) sqrt(n);
    }    
}
