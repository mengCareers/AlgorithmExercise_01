/*
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class FindMajorityLinear {
    int findMajority(int[] a) {
        int c = findCandidate(a);
        int cnt = 0;
        for (int i : a)
            if (c == i)
                cnt++;
        if (cnt >= ((a.length + 1) / 2))
            return c;
        else 
            return Integer.MAX_VALUE;
    }
    
    int findCandidate(int[] a) {
        int c = a[0];
        int cnt = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != c)
                cnt--;
            else
                cnt++;
            if (cnt == 0) {
                c = a[i];
                cnt = 1;
            }
        }
        return c;
    }
}
