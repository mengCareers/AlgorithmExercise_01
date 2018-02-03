package Heap;

/* Q: 313. Super Ugly Number
Super Ugly Number: positive numbers whose all prime factors are in primes[]
return the nth Super Ugly Number
 * Thought Process:
sort primes, and backtrack product 
 * Get:
    - How do we get Ugly Number? prev Ugly Number * prime, like Ugly Number II
    - What's the dif with Ugly Number II? use loop to replace i2, i3, i5
 * 
 */

/**
 *
 * @author xinrong
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] ptrs = new int[len];
        int[] res = new int[n];
        res[0] = 1;
        
        for(int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                res[i] = Math.min(res[i], res[ptrs[j]] * primes[j]);
            }
            for (int j = 0; j < len; j++) {
                if (res[i] == primes[j] * res[ptrs[j]])
                    ptrs[j]++;
            }
        }
        return res[n - 1];
    }
}
