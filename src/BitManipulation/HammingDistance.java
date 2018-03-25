/* 461. Hamming Distance
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Thought Process:
1   (0 0 0 1)
4   (0 1 0 0)
1 ^ 4 = 0 1 0 1
cnt 1
&       0 0 0 1
 */
package BitManipulation;

/**
 * 
 * @author xinrong
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int dif = x ^ y;
        return cntOnes(dif);
    }

    private int cntOnes(int n) {
        int cnt = 0;
        while (n != 0) {
            n = resetLastOnetoZero(n);
            cnt++;
        }
        return cnt;
    }

    private int resetLastOnetoZero(int n) {
        n = n & (n - 1);
        return n;
    }
}
