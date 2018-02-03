package DynamicProgramming;

/*
 *  Q: 264.Ugly Number II
input : n
output: nth ugly number (prime factors only include 2, 3, 5)
 *  Get:
- How do we get a ugly ? a ugly =  a ugly * 2 / 3 / 5
k[1] = min( k[0]x2, k[0]x3, k[0]x5) = k[0] x 2 (move 2's ptr from 0 to 1)
k[2] = min( k[1]x2, k[0]x3, k[0]x5)
if 6, forward ptr 2 and forward ptr 3
 */

/**
 *
 * @author xinrong
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        int p2 = 0, p3 = 0, p5 = 0; // ptrs for 2, 3, 5
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
            if (res[i] == res[p2] * 2)
                p2++;
            if (res[i] == res[p3] * 3)
                p3++;
            if (res[i] == res[p5] * 5)
                p5++;
        }        
        return res[n - 1];
    }
}
